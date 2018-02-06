package br.comar.ricardo.stuff.camel.pojo;

public class CamelBean {
	
	public CamelBean(Integer intA, Integer intB, CamelOperation op,
			Integer result) {
		super();
		this.intA = intA;
		this.intB = intB;
		this.op = op;
		this.result = result;
	}

	private Integer intA;

	private Integer intB;
	
	private CamelOperation op;
	
	private Integer result;

	public Integer getIntA() {
		return intA;
	}

	public void setIntA(Integer intA) {
		this.intA = intA;
	}

	public Integer getIntB() {
		return intB;
	}

	public void setIntB(Integer intB) {
		this.intB = intB;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public CamelOperation getOp() {
		return op;
	}

	public void setOp(CamelOperation op) {
		this.op = op;
	}
	
}
