package jcrystal.http.responses;
public class HttpPaymentRequired402 extends HttpResponseException{
	public HttpPaymentRequired402(String content) {
		super(402, content);
	}
	public HttpPaymentRequired402() {
		super(402, null);
	}
}
