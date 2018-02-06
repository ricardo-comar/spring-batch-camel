package br.comar.ricardo.stuff.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import br.comar.ricardo.stuff.camel.processor.CamelProcessor;
import br.comar.ricardo.stuff.camel.processor.WebServiceProcessor;

@Component
public class CamelRoute extends RouteBuilder {

	@Autowired
	private ApplicationContext context;

	@Override
	public void configure() throws Exception {
		from(CamelProcessor.SERVICE_ENDPOINT)
			.id(CamelProcessor.ROUTE_ID)
			.log("CamelProcessor Route")
			.process(context.getBean(CamelProcessor.class));

		from(WebServiceProcessor.SERVICE_ENDPOINT)
		.id(WebServiceProcessor.ROUTE_ID)
		.log("WebServiceProcessor Route")
		.process(context.getBean(WebServiceProcessor.class));
	}

}
