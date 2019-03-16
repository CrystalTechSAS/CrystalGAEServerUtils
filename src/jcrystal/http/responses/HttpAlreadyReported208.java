package jcrystal.http.responses;
public class HttpAlreadyReported208 extends HttpResponseException{
	public HttpAlreadyReported208(String content) {
		super(208, content);
	}
	public HttpAlreadyReported208() {
		super(208, null);
	}
}
