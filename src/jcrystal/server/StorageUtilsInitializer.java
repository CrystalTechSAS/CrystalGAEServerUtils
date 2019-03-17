package jcrystal.server;

import com.google.appengine.api.appidentity.AppIdentityServiceFactory;

public class StorageUtilsInitializer {
	public static String getDEFAULT_BUCKET() {
		if(StorageUtils.DEFAULT_BUCKET == null)
			return StorageUtils.DEFAULT_BUCKET = AppIdentityServiceFactory.getAppIdentityService().getDefaultGcsBucketName();
		return StorageUtils.DEFAULT_BUCKET;
	}
}
