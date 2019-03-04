package jcrystal.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;

import com.google.appengine.api.appidentity.AppIdentityServiceFactory;
import com.google.appengine.tools.cloudstorage.GcsFileOptions;
import com.google.appengine.tools.cloudstorage.GcsFilename;
import com.google.appengine.tools.cloudstorage.GcsOutputChannel;
import com.google.appengine.tools.cloudstorage.GcsService;
import com.google.appengine.tools.cloudstorage.GcsServiceFactory;
import com.google.appengine.tools.cloudstorage.RetryParams;

public class StorageUtils {
	private static String DEFAULT_BUCKET;
	public static String getDEFAULT_BUCKET() {
		if(DEFAULT_BUCKET == null)
			return DEFAULT_BUCKET = AppIdentityServiceFactory.getAppIdentityService().getDefaultGcsBucketName();
		return DEFAULT_BUCKET;
	}
}
