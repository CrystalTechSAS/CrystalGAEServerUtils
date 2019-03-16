package jcrystal.http.responses;
public class HttpMultipleChoices300 extends HttpResponseException{
	public HttpMultipleChoices300(String content) {
		super(300, content);
	}
	public HttpMultipleChoices300() {
		super(300, null);
	}
}
