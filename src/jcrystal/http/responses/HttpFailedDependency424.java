package jcrystal.http.responses;
public class HttpFailedDependency424 extends HttpResponseException{
	public HttpFailedDependency424(String content) {
		super(424, content);
	}
	public HttpFailedDependency424() {
		super(424, null);
	}
}
