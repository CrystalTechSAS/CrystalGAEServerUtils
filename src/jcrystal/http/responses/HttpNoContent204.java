package jcrystal.http.responses;
public class HttpNoContent204 extends HttpResponseException{
	public HttpNoContent204(String content) {
		super(204, content);
	}
	public HttpNoContent204() {
		super(204, null);
	}
}
