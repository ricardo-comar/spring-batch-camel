package br.comar.ricardo.stuff.camel.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.ExchangeBuilder;
import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.beans.factory.annotation.Autowired;

import br.comar.ricardo.stuff.camel.pojo.CamelBean;
import br.comar.ricardo.stuff.camel.pojo.CamelOperation;
import br.comar.ricardo.stuff.camel.processor.CamelProcessor;

@Path("/camel")
@Produces( MediaType.APPLICATION_JSON)
public class CamelResource {
	
	@Autowired
	private ProducerTemplate producer;
	
	@Autowired
	private CamelContext camelContext;

	@GET
	@Path("/calc/{intA}/{op}/{intB}")
	@ManagedAsync
	public void asyncNIO(@Suspended final AsyncResponse asyncResponse,
			@PathParam("intA") Integer intA,
			@PathParam("op") String op,
			@PathParam("intB") Integer intB) {
		
		final CamelBean requestBody = new CamelBean(intA, intB, CamelOperation.valueOf(op.toUpperCase()), null);
		final Exchange requestExchange = ExchangeBuilder.anExchange(camelContext).withBody(requestBody).build();

		final Exchange responseExchange = producer.send(CamelProcessor.SERVICE_ENDPOINT, requestExchange);
		final CamelBean responseBody = responseExchange.getOut().getBody(CamelBean.class);
		
		asyncResponse.resume(responseBody);
	}

}