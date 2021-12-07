package br.com.tema.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CartaInvalidaExceptionMapper implements ExceptionMapper<CartaInvalidaException>{

	@Override
	public Response toResponse(CartaInvalidaException ex) {
		return Response.status(Response.Status.BAD_REQUEST).entity(ex).type(MediaType.APPLICATION_JSON).build();
	}

}
