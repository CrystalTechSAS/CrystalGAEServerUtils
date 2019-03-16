package jcrystal.http.responses;
public class HttpPartialContent206 extends HttpResponseException{
	public HttpPartialContent206(String content) {
		super(206, content);
	}
	public HttpPartialContent206() {
		super(206, null);
	}
}
