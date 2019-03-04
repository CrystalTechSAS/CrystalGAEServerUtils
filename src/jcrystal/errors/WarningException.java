package jcrystal.errors;

import jcrystal.utils.InternalException;

public class WarningException extends InternalException{
	
	private static final long serialVersionUID = 1L;
	
	public WarningException(String mensaje) {
		super(100, mensaje);
	}
	public WarningException(int code, String mensaje) {
		super(code%100 + 100, mensaje);
	}
	
}
