package jcrystal.http.responses;
public class HttpResetContent205 extends HttpResponseException{
	public HttpResetContent205(String content) {
		super(205, content);
	}
	public HttpResetContent205() {
		super(205, null);
	}
}
