package jcrystal.http.responses;
public class HttpMethodNotAllowed405 extends HttpResponseException{
	public HttpMethodNotAllowed405(String content) {
		super(405, content);
	}
	public HttpMethodNotAllowed405() {
		super(405, null);
	}
}
