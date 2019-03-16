package jcrystal.http.responses;
public class HttpPermanentRedirect308 extends HttpResponseException{
	public HttpPermanentRedirect308(String content) {
		super(308, content);
	}
	public HttpPermanentRedirect308() {
		super(308, null);
	}
}
