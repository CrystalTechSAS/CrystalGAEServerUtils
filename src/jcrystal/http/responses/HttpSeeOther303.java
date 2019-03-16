package jcrystal.http.responses;
public class HttpSeeOther303 extends HttpResponseException{
	public HttpSeeOther303(String content) {
		super(303, content);
	}
	public HttpSeeOther303() {
		super(303, null);
	}
}
