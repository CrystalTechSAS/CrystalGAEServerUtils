package jcrystal.http.responses;
public class HttpInsufficientStorage507 extends HttpResponseException{
	public HttpInsufficientStorage507(String content) {
		super(507, content);
	}
	public HttpInsufficientStorage507() {
		super(507, null);
	}
}
