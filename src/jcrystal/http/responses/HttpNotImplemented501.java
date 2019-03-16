package jcrystal.http.responses;
public class HttpNotImplemented501 extends HttpResponseException{
	public HttpNotImplemented501(String content) {
		super(501, content);
	}
	public HttpNotImplemented501() {
		super(501, null);
	}
}
