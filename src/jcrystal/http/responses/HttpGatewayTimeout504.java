package jcrystal.http.responses;
public class HttpGatewayTimeout504 extends HttpResponseException{
	public HttpGatewayTimeout504(String content) {
		super(504, content);
	}
	public HttpGatewayTimeout504() {
		super(504, null);
	}
}
