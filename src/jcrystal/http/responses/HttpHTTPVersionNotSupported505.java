package jcrystal.http.responses;
public class HttpHTTPVersionNotSupported505 extends HttpResponseException{
	public HttpHTTPVersionNotSupported505(String content) {
		super(505, content);
	}
	public HttpHTTPVersionNotSupported505() {
		super(505, null);
	}
}
