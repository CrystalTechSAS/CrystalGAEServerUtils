/* Copyright (C) Germán Augusto Sotelo Arévalo - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Germán Augusto Sotelo Arévalo <gasotelo@crystaltech.co>, December 2018
 */
package jcrystal.server;

import com.google.appengine.api.appidentity.AppIdentityServiceFactory;

public class StorageUtilsInitializer {
	public static String getDEFAULT_BUCKET() {
		if(StorageUtils.DEFAULT_BUCKET == null)
			return StorageUtils.DEFAULT_BUCKET = AppIdentityServiceFactory.getAppIdentityService().getDefaultGcsBucketName();
		return StorageUtils.DEFAULT_BUCKET;
	}
}
