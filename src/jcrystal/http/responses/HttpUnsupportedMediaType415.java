package jcrystal.http.responses;
public class HttpUnsupportedMediaType415 extends HttpResponseException{
	public HttpUnsupportedMediaType415(String content) {
		super(415, content);
	}
	public HttpUnsupportedMediaType415() {
		super(415, null);
	}
}
