package br.comar.ricardo.stuff.camel;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import br.comar.ricardo.stuff.camel.resources.CamelResource;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(CamelResource.class);
	}

}