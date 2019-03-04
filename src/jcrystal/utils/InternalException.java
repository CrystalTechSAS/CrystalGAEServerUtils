package jcrystal.utils;

public class InternalException extends RuntimeException{
	/**
	*
	*/
	private static final long serialVersionUID = 7111184985492759212L;
	public final int code;
	public InternalException(int code, String mensaje){
		super(mensaje);
		this.code = code;
	}
}
