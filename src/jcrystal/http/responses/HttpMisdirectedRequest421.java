package jcrystal.http.responses;
public class HttpMisdirectedRequest421 extends HttpResponseException{
	public HttpMisdirectedRequest421(String content) {
		super(421, content);
	}
	public HttpMisdirectedRequest421() {
		super(421, null);
	}
}
