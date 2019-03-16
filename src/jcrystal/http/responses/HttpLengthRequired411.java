package jcrystal.http.responses;
public class HttpLengthRequired411 extends HttpResponseException{
	public HttpLengthRequired411(String content) {
		super(411, content);
	}
	public HttpLengthRequired411() {
		super(411, null);
	}
}
