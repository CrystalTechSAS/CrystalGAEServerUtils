package jcrystal.http.responses;
public class HttpProxyAuthenticationRequired407 extends HttpResponseException{
	public HttpProxyAuthenticationRequired407(String content) {
		super(407, content);
	}
	public HttpProxyAuthenticationRequired407() {
		super(407, null);
	}
}
