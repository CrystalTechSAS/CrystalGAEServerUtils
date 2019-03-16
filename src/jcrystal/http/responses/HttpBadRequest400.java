package jcrystal.http.responses;
public class HttpBadRequest400 extends HttpResponseException{
	public HttpBadRequest400(String content) {
		super(400, content);
	}
	public HttpBadRequest400() {
		super(400, null);
	}
}
