package jcrystal.http.responses;
public class HttpNonAuthoritativeInformation203 extends HttpResponseException{
	public HttpNonAuthoritativeInformation203(String content) {
		super(203, content);
	}
	public HttpNonAuthoritativeInformation203() {
		super(203, null);
	}
}
