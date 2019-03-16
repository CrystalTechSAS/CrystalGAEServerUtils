package jcrystal.http.responses;
public class HttpConnectionClosedWithoutResponse444 extends HttpResponseException{
	public HttpConnectionClosedWithoutResponse444(String content) {
		super(444, content);
	}
	public HttpConnectionClosedWithoutResponse444() {
		super(444, null);
	}
}
