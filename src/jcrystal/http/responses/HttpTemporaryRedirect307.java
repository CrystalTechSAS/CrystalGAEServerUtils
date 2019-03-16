package jcrystal.http.responses;
public class HttpTemporaryRedirect307 extends HttpResponseException{
	public HttpTemporaryRedirect307(String content) {
		super(307, content);
	}
	public HttpTemporaryRedirect307() {
		super(307, null);
	}
}
