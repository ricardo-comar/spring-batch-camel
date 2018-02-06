package br.comar.ricardo.stuff.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.comar.ricardo.stuff.camel.pojo.CamelBean;
import calculator.webservice.Calculator;
import calculator.webservice.CalculatorSoap;

@Component
@Scope("prototype")
public class WebServiceProcessor implements Processor {

	public static final String ROUTE_ID = "WSCalcAdd";
	public static final String SERVICE_ENDPOINT = "direct:ws-calc-add";

	@Override
	public void process(Exchange exchange) throws Exception {
		
		CamelBean body = exchange.getIn().getBody(CamelBean.class);
		
		Calculator wsCalc = new Calculator();
		CalculatorSoap soap = wsCalc.getCalculatorSoap();
		
		switch(body.getOp()) {
		case ADD: 
			body.setResult(soap.add(body.getIntA(), body.getIntB()));
			break;
		case SUBTRACT: 
			body.setResult(soap.subtract(body.getIntA(), body.getIntB()));
			break;
		case DIVIDE: 
			body.setResult(soap.divide(body.getIntA(), body.getIntB()));
			break;
		case MULTIPLY: 
			body.setResult(soap.multiply(body.getIntA(), body.getIntB()));
			break;
		}
		
		exchange.getOut().setBody(body);
	}

}
