package jcrystal.http.responses;
public class HttpNotFound404 extends HttpResponseException{
	public HttpNotFound404(String content) {
		super(404, content);
	}
	public HttpNotFound404() {
		super(404, null);
	}
}
