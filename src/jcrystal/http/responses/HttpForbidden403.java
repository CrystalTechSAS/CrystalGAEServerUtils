package jcrystal.http.responses;
public class HttpForbidden403 extends HttpResponseException{
	public HttpForbidden403(String content) {
		super(403, content);
	}
	public HttpForbidden403() {
		super(403, null);
	}
}
