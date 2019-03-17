/* Copyright (C) Germán Augusto Sotelo Arévalo - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Germán Augusto Sotelo Arévalo <gasotelo@crystaltech.co>, December 2018
 */
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

public class FileWrapperResponseUtils implements IFileWrapperResponseUtils {
	public <T> String asString(FileWrapperResponse<T> wrapper) throws IOException{
		StringWriter sw = new StringWriter();
		append(wrapper, sw, false);
		return sw.toString();
	}
	public <T> void append(FileWrapperResponse<T> wrapper, Writer output, boolean putFirst) throws IOException{
		final GcsService gcsService = GcsServiceFactory.createGcsService(new RetryParams.Builder()
		.initialRetryDelayMillis(10)
		.retryMaxAttempts(10)
		.totalRetryPeriodMillis(15000)
		.build());
		GcsFilename name;
		if(wrapper.getBucketName() == null) {
			AppIdentityService appIdentity = AppIdentityServiceFactory.getAppIdentityService();
			name = new GcsFilename(appIdentity.getDefaultGcsBucketName(), wrapper.getFileName());
		}else name = new GcsFilename(wrapper.getBucketName(), wrapper.getFileName());
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
