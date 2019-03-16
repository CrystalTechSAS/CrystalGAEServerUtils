package jcrystal.http.responses;
public class HttpNotExtended510 extends HttpResponseException{
	public HttpNotExtended510(String content) {
		super(510, content);
	}
	public HttpNotExtended510() {
		super(510, null);
	}
}
