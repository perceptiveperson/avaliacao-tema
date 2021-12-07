package br.com.tema.exception.handler;

import java.util.Date;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.tema.exception.CartaInvalidaException;
import br.com.tema.exception.details.CartaInvalidaDetails;

//@ControllerAdvice
public class CartaExceptionHandler {
	
	//@ExceptionHandler(CartaInvalidaException.class)
	public Response handlerCartaInvalidaException(CartaInvalidaException ex) {		
		
		CartaInvalidaDetails cartaDetails =  CartaInvalidaDetails.Builder.newInstance()
			.titulo("titulo teste")
			.status(404)
			.detalhes("detalhe teste")
			.timestamp(new Date().getTime()).builder();
		return Response.status(Response.Status.BAD_REQUEST).entity(cartaDetails).type(MediaType.APPLICATION_JSON).build();
	}

}
