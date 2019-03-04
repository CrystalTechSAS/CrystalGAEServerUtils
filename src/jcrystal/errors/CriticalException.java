package jcrystal.errors;

import jcrystal.utils.InternalException;

public class CriticalException extends InternalException{
	
	private static final long serialVersionUID = 1L;
	
	public CriticalException(String mensaje) {
		super(300, mensaje);
	}
	public CriticalException(int code, String mensaje) {
		super(code%100 + 300, mensaje);
	}
	
}
