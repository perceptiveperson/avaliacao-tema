package br.com.tema.exception;

public class CartaInvalidaException extends RuntimeException  {
	private static final long serialVersionUID = 479154887572668147L;

	public CartaInvalidaException(String msg) {
		super(msg);
	}
}
