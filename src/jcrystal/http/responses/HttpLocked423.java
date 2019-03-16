package jcrystal.http.responses;
public class HttpLocked423 extends HttpResponseException{
	public HttpLocked423(String content) {
		super(423, content);
	}
	public HttpLocked423() {
		super(423, null);
	}
}
