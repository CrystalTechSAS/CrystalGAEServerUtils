package jcrystal.http.responses;
public class HttpTooManyRequests429 extends HttpResponseException{
	public HttpTooManyRequests429(String content) {
		super(429, content);
	}
	public HttpTooManyRequests429() {
		super(429, null);
	}
}
