package jcrystal.utils;

public class ValidationException extends RuntimeException{
	/**
	*
	*/
	private static final long serialVersionUID = 7111184985492759212L;
	public ValidationException(String mensaje){
		super(mensaje);
	}
}
