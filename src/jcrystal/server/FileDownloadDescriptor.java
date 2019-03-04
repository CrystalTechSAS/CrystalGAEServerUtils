package jcrystal.server;

public class FileDownloadDescriptor {

	public final String bucketName;
	public final String path;
	public FileDownloadDescriptor(String bucketName, String path) {
		this.bucketName = bucketName;
		this.path = path;
	}
	public FileDownloadDescriptor(String path) {
		this.bucketName = StorageUtils.getDEFAULT_BUCKET();
		this.path = path;
	}
	
}
