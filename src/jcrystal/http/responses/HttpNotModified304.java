package jcrystal.http.responses;
public class HttpNotModified304 extends HttpResponseException{
	public HttpNotModified304(String content) {
		super(304, content);
	}
	public HttpNotModified304() {
		super(304, null);
	}
}
