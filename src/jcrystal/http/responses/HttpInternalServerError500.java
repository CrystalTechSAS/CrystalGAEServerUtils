package jcrystal.http.responses;
public class HttpInternalServerError500 extends HttpResponseException{
	public HttpInternalServerError500(String content) {
		super(500, content);
	}
	public HttpInternalServerError500() {
		super(500, null);
	}
}
