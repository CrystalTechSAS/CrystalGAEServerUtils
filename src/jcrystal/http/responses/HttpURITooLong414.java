package jcrystal.http.responses;
public class HttpURITooLong414 extends HttpResponseException{
	public HttpURITooLong414(String content) {
		super(414, content);
	}
	public HttpURITooLong414() {
		super(414, null);
	}
}
