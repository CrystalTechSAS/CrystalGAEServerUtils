package jcrystal.errors;

import jcrystal.utils.InternalException;

public class InfoException extends InternalException{
	
	private static final long serialVersionUID = 1L;
	
	public InfoException(String mensaje) {
		super(0, mensaje);
	}
	public InfoException(int code, String mensaje) {
		super(code%100, mensaje);
	}
	
}
