package jcrystal.http.responses;
public class HttpRequestHeaderFieldsTooLarge431 extends HttpResponseException{
	public HttpRequestHeaderFieldsTooLarge431(String content) {
		super(431, content);
	}
	public HttpRequestHeaderFieldsTooLarge431() {
		super(431, null);
	}
}
