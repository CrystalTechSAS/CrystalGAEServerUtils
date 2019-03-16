package jcrystal.http.responses;
public class HttpIMUsed226 extends HttpResponseException{
	public HttpIMUsed226(String content) {
		super(226, content);
	}
	public HttpIMUsed226() {
		super(226, null);
	}
}
