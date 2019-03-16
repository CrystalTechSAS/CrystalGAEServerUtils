package jcrystal.http.responses;

public class HttpResponseException extends NullPointerException{
	private int code;
	private String content; 
	
	public HttpResponseException(int code, String content) {
		this.code = code;
		this.content = content;
	}
	public int getCode() {
		return code;
	}
	public String getContent() {
		return content;
	}
}