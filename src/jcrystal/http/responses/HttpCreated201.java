package jcrystal.http.responses;
public class HttpCreated201 extends HttpResponseException{
	public HttpCreated201(String content) {
		super(201, content);
	}
	public HttpCreated201() {
		super(201, null);
	}
}
