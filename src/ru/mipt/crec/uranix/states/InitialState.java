package ru.mipt.crec.uranix.states;

import ru.mipt.crec.uranix.Calculator;

public class InitialState extends State {
	
	public InitialState(Calculator calc) {
		this(calc, null, null);
	}
	
	public InitialState(Calculator calc, String errmsg, String resmsg) {
		super(calc, errmsg, resmsg);
	}
	
	@Override
	public State parseLine(String line) {
		try {
			double val = Double.parseDouble(line);
			return new HaveFirstArgumentState(getCalc(), val, null);
		} catch (NumberFormatException e) {
			return new InitialState(getCalc(), "Invalid number: " + e.getMessage(), null);
		}
	}	
	
	@Override
	public String getPromptMessage() {
		return "first arg > ";
	}	

}
