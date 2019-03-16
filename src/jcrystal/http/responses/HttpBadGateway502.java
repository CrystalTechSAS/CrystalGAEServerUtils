package jcrystal.http.responses;
public class HttpBadGateway502 extends HttpResponseException{
	public HttpBadGateway502(String content) {
		super(502, content);
	}
	public HttpBadGateway502() {
		super(502, null);
	}
}
