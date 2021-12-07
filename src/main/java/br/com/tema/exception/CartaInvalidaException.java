package br.com.tema.exception;

import javax.ws.rs.WebApplicationException;

public class CartaInvalidaException extends WebApplicationException  {
	private static final long serialVersionUID = 479154887572668147L;

	public CartaInvalidaException(String msg) {
		super(msg);
	}
}
