package jcrystal.manager.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.channels.Channels;

import com.google.appengine.api.appidentity.AppIdentityService;
import com.google.appengine.api.appidentity.AppIdentityServiceFactory;
import com.google.appengine.tools.cloudstorage.GcsFilename;
import com.google.appengine.tools.cloudstorage.GcsInputChannel;
import com.google.appengine.tools.cloudstorage.GcsService;
import com.google.appengine.tools.cloudstorage.GcsServiceFactory;
import com.google.appengine.tools.cloudstorage.RetryParams;

public class FileWrapperResponse<T> {
	private final String bucketName;
	private final String fileName;
	private T item;
	
	public FileWrapperResponse(T item) {
		this(null,null);
		this.item = item;
	}
	public FileWrapperResponse(String fileName) {
		this(null, fileName);
	}
	public FileWrapperResponse(String bucketName, String fileName) {
		this.bucketName = bucketName;
		this.fileName = fileName;
	}
	public T getItem() {
		if(bucketName == null && fileName == null)
			return item;
		return null;
	}
	public String asString() throws IOException{
		StringWriter sw = new StringWriter();
		append(sw, false);
		return sw.toString();
	}
	public void append(Writer output, boolean putFirst) throws IOException{
		final GcsService gcsService = GcsServiceFactory.createGcsService(new RetryParams.Builder()
		.initialRetryDelayMillis(10)
		.retryMaxAttempts(10)
		.totalRetryPeriodMillis(15000)
		.build());
		GcsFilename name;
		if(bucketName == null) {
			AppIdentityService appIdentity = AppIdentityServiceFactory.getAppIdentityService();
			name = new GcsFilename(appIdentity.getDefaultGcsBucketName(), fileName);
		}else name = new GcsFilename(bucketName, fileName);
		GcsInputChannel readChannel = gcsService.openPrefetchingReadChannel(name, 0, 1024*1024);
		copy(Channels.newInputStream(readChannel), output, putFirst?0:1);
	}
	
	private void copy(InputStream input, Writer output, int skip) throws IOException {
		try(InputStreamReader reader = new InputStreamReader(input)){
			while(skip-->0)
			reader.read();
			char[] buffer = new char[10*1024];
			for(int bytesRead; (bytesRead=reader.read(buffer)) != -1;){
				output.write(buffer, 0, bytesRead);
			}
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
