package jcrystal.http.responses;
public class HttpPayloadTooLarge413 extends HttpResponseException{
	public HttpPayloadTooLarge413(String content) {
		super(413, content);
	}
	public HttpPayloadTooLarge413() {
		super(413, null);
	}
}
