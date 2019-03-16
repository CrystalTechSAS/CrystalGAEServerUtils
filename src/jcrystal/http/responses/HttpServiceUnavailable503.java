package jcrystal.http.responses;
public class HttpServiceUnavailable503 extends HttpResponseException{
	public HttpServiceUnavailable503(String content) {
		super(503, content);
	}
	public HttpServiceUnavailable503() {
		super(503, null);
	}
}
