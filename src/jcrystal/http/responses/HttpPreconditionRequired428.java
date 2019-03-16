package jcrystal.http.responses;
public class HttpPreconditionRequired428 extends HttpResponseException{
	public HttpPreconditionRequired428(String content) {
		super(428, content);
	}
	public HttpPreconditionRequired428() {
		super(428, null);
	}
}
