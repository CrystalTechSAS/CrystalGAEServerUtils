package jcrystal.http.responses;
public class HttpExpectationFailed417 extends HttpResponseException{
	public HttpExpectationFailed417(String content) {
		super(417, content);
	}
	public HttpExpectationFailed417() {
		super(417, null);
	}
}
