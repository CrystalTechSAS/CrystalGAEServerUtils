/* Copyright (C) Germán Augusto Sotelo Arévalo - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Germán Augusto Sotelo Arévalo <gasotelo@crystaltech.co.com>, December 2018
 */
package jcrystal.db.storage;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.appidentity.AppIdentityServiceFactory;
import com.google.appengine.tools.cloudstorage.GcsFileMetadata;
import com.google.appengine.tools.cloudstorage.GcsFileOptions;
import com.google.appengine.tools.cloudstorage.GcsFilename;

import jcrystal.server.FileDownloadDescriptor;
public class StorageUtils {
	static String DEFAULT_BUCKET;
	public static String getDEFAULT_BUCKET() {
		if(DEFAULT_BUCKET == null) {
			DEFAULT_BUCKET = AppIdentityServiceFactory.getAppIdentityService().getDefaultGcsBucketName();
		}
		return DEFAULT_BUCKET;
	}
	public static void serve(FileDownloadDescriptor descriptor, HttpServletResponse resp) throws IOException {
		com.google.appengine.tools.cloudstorage.GcsService gcsService = com.google.appengine.tools.cloudstorage.GcsServiceFactory.createGcsService();
		GcsFileMetadata meta = gcsService.getMetadata(new GcsFilename(descriptor.bucketName, descriptor.path));
		com.google.appengine.api.blobstore.BlobstoreService blobstoreService = com.google.appengine.api.blobstore.BlobstoreServiceFactory.getBlobstoreService();
		com.google.appengine.api.blobstore.BlobKey blobKey = blobstoreService.createGsBlobKey("/gs/" + descriptor.bucketName+"/" + descriptor.path);
		if(meta != null) {
			GcsFileOptions options = meta.getOptions();
			if(meta != null) {
				if(options.getMimeType() != null)
					resp.setContentType(options.getMimeType());
				if(options.getContentDisposition() != null)
					resp.setHeader("Content-Disposition", options.getContentDisposition());
			}
		}
		resp.setStatus(200);
		blobstoreService.serve(blobKey, resp);
	}
}
