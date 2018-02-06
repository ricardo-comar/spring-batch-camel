package br.comar.ricardo.stuff.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.comar.ricardo.stuff.camel.pojo.CamelBean;

@Component
@Scope("prototype")
public class CamelProcessor implements Processor {

	public static final String ROUTE_ID = "CalcAdd";
	public static final String SERVICE_ENDPOINT = "direct:calc-add";

	@Override
	public void process(Exchange exchange) throws Exception {
		
		CamelBean body = exchange.getIn().getBody(CamelBean.class);
		Integer result = 0;
		
		switch(body.getOp()) {
		case ADD: 
			result = body.getIntA() + body.getIntB();
			break;
		case SUBTRACT: 
			result = body.getIntA() - body.getIntB();
			break;
		case DIVIDE: 
			result = body.getIntA() / body.getIntB();
			break;
		case MULTIPLY: 
			result = body.getIntA() * body.getIntB();
			break;
		}
		
		body.setResult(result);
		
		exchange.getOut().setBody(body);
	}

}
