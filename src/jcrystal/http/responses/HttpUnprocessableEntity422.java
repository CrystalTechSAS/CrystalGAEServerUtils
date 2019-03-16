package jcrystal.http.responses;
public class HttpUnprocessableEntity422 extends HttpResponseException{
	public HttpUnprocessableEntity422(String content) {
		super(422, content);
	}
	public HttpUnprocessableEntity422() {
		super(422, null);
	}
}
