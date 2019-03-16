package jcrystal.http.responses;
public class HttpRequestedRangeNotSatisfiable416 extends HttpResponseException{
	public HttpRequestedRangeNotSatisfiable416(String content) {
		super(416, content);
	}
	public HttpRequestedRangeNotSatisfiable416() {
		super(416, null);
	}
}
