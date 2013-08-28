package ru.mipt.crec.uranix.states;

import ru.mipt.crec.uranix.Calculator;

public abstract class State {
	private Calculator calc;
	private String errmsg;
	private String resmsg;
	
	public State(Calculator calc, String errmsg, String resmsg) {
		this.calc = calc;
		this.errmsg = errmsg;
		this.resmsg = resmsg;
	}
	
	final protected Calculator getCalc() {
		return calc;
	}
	
	abstract public String getPromptMessage();
	
	abstract public State parseLine(String line);
	
	final public String getErrorMessage() {
		return errmsg;
	}
	
	final public String getResultMessage() {
		return resmsg;
	}
}
