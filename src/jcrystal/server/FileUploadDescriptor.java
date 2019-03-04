package jcrystal.server;

public class FileUploadDescriptor {

	public final String bucketName;
	public final String path;
	public Runnable onSuccess;
	public FileUploadDescriptor(String bucketName, String path) {
		this.bucketName = bucketName;
		this.path = path;
	}
	public FileUploadDescriptor(String path) {
		this.bucketName = StorageUtils.getDEFAULT_BUCKET();
		this.path = path;
	}
	public FileUploadDescriptor onSuccess(Runnable onSuccess) {
		this.onSuccess = onSuccess;
		return this;
	}
}
