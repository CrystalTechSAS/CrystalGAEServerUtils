package jcrystal.http.responses;
public class HttpPreconditionFailed412 extends HttpResponseException{
	public HttpPreconditionFailed412(String content) {
		super(412, content);
	}
	public HttpPreconditionFailed412() {
		super(412, null);
	}
}
