package br.com.tema.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.tema.domain.Carta;
import br.com.tema.enums.Classe;
import br.com.tema.enums.Tipo;
import br.com.tema.exception.CartaInvalidaException;
import br.com.tema.repository.CartaRepository;

@Path("/carta")
public class CartaResource {
	
	@Autowired
	private CartaRepository cartaRepository;
	@Context
	protected UriInfo uriInfo;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response buscarTodos() {
		return Response.ok().entity(cartaRepository.findAll()).build();
	}
	
	@GET
	@Path("/id/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorId(@PathParam("id") int id) {
		Optional<Carta> carta = cartaRepository.findById(id);
		return carta.isPresent() ?
				Response.ok().entity(carta).build() :
					Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@GET
	@Path("/nome/{nome}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorNome(@PathParam("nome") String nome) {
		List<Optional<Carta>> cartas  = cartaRepository.findByNomeCarta(nome);
		return !cartas.isEmpty() ?
				Response.ok().entity(cartas).build() :
					Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@GET
	@Path("/tipo/{tipo}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorTipo(@PathParam("tipo") Tipo tipo) {
		List<Optional<Carta>> cartas  = cartaRepository.findByTipoCarta(tipo);
		return !cartas.isEmpty() ?
				Response.ok().entity(cartas).build() :
					Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@GET
	@Path("/classe/{classe}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorNome(@PathParam("classe") Classe classe) {
		List<Optional<Carta>> cartas = cartaRepository.findByClasseCarta(classe);
		return !cartas.isEmpty() ?
				Response.ok().entity(cartas).build() :
					Response.status(Response.Status.NOT_FOUND).build();
	}
	
	@POST
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar(Carta carta) throws CartaInvalidaException {
		Carta c = cartaRepository.save(carta);
		
		if( c != null ) {									
			return Response.created(URI.create(uriInfo.getBaseUri()+"id/"+c.getId()))
					.entity("Carta Criada!")
					.build();
		}else 
			return Response.status(Response.Status.EXPECTATION_FAILED).build();
	}
	
	@DELETE
	@Path("/id/{id}")
	public Response excluir(@PathParam("id") int id) {
		if(cartaRepository.existsById(id)) {
			cartaRepository.deleteById(id);
			return Response.ok().entity("Objeto removido").build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

}
