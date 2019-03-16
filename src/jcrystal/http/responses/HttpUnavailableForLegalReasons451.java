package jcrystal.http.responses;
public class HttpUnavailableForLegalReasons451 extends HttpResponseException{
	public HttpUnavailableForLegalReasons451(String content) {
		super(451, content);
	}
	public HttpUnavailableForLegalReasons451() {
		super(451, null);
	}
}
