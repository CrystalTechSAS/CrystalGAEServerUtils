package jcrystal.http.responses;
public class HttpUpgradeRequired426 extends HttpResponseException{
	public HttpUpgradeRequired426(String content) {
		super(426, content);
	}
	public HttpUpgradeRequired426() {
		super(426, null);
	}
}
