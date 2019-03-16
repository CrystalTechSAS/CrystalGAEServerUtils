package jcrystal.http.responses;
public class HttpMultiStatus207 extends HttpResponseException{
	public HttpMultiStatus207(String content) {
		super(207, content);
	}
	public HttpMultiStatus207() {
		super(207, null);
	}
}
