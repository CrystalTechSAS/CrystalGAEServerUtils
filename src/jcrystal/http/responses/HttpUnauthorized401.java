package jcrystal.http.responses;
public class HttpUnauthorized401 extends HttpResponseException{
	public HttpUnauthorized401(String content) {
		super(401, content);
	}
	public HttpUnauthorized401() {
		super(401, null);
	}
}
