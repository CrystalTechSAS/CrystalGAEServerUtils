package jcrystal.http.responses;
public class HttpConflict409 extends HttpResponseException{
	public HttpConflict409(String content) {
		super(409, content);
	}
	public HttpConflict409() {
		super(409, null);
	}
}
