package jcrystal.http.responses;
public class HttpMovedPermanently301 extends HttpResponseException{
	public HttpMovedPermanently301(String content) {
		super(301, content);
	}
	public HttpMovedPermanently301() {
		super(301, null);
	}
}
