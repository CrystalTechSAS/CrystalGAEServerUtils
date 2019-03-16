package jcrystal.http.responses;
public class HttpNotAcceptable406 extends HttpResponseException{
	public HttpNotAcceptable406(String content) {
		super(406, content);
	}
	public HttpNotAcceptable406() {
		super(406, null);
	}
}
