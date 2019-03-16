package jcrystal.http.responses;
public class HttpUseProxy305 extends HttpResponseException{
	public HttpUseProxy305(String content) {
		super(305, content);
	}
	public HttpUseProxy305() {
		super(305, null);
	}
}
