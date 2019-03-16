package jcrystal.http.responses;
public class HttpGone410 extends HttpResponseException{
	public HttpGone410(String content) {
		super(410, content);
	}
	public HttpGone410() {
		super(410, null);
	}
}
