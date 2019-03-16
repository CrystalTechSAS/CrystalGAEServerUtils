package jcrystal.http.responses;
public class HttpFound302 extends HttpResponseException{
	public HttpFound302(String content) {
		super(302, content);
	}
	public HttpFound302() {
		super(302, null);
	}
}
