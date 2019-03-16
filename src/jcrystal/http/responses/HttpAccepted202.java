package jcrystal.http.responses;
public class HttpAccepted202 extends HttpResponseException{
	public HttpAccepted202(String content) {
		super(202, content);
	}
	public HttpAccepted202() {
		super(202, null);
	}
}
