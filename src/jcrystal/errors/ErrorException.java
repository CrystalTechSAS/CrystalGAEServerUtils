package jcrystal.errors;

import jcrystal.utils.InternalException;

public class ErrorException extends InternalException{
	
	private static final long serialVersionUID = 1L;
	
	public ErrorException(String mensaje) {
		super(200, mensaje);
	}
	public ErrorException(int code, String mensaje) {
		super(code%100 + 200, mensaje);
	}
	
}
