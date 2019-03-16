package jcrystal.http.responses;
public class HttpRequestTimeout408 extends HttpResponseException{
	public HttpRequestTimeout408(String content) {
		super(408, content);
	}
	public HttpRequestTimeout408() {
		super(408, null);
	}
}
