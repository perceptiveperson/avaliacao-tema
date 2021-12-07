package br.com.tema.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import br.com.tema.resource.CartaResource;

@Configuration
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		register(CartaResource.class);
	}

}
