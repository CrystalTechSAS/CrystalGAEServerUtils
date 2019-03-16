package jcrystal.http.responses;
public class HttpLoopDetected508 extends HttpResponseException{
	public HttpLoopDetected508(String content) {
		super(508, content);
	}
	public HttpLoopDetected508() {
		super(508, null);
	}
}
