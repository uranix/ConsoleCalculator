package ru.mipt.crec.uranix.states;

import ru.mipt.crec.uranix.Calculator;
import ru.mipt.crec.uranix.operations.BinaryOperation;

public class HaveArgumentAndOperation extends State {
	
	private BinaryOperation bop;
	private double arg0;

	public HaveArgumentAndOperation(Calculator calc, double arg0,
			BinaryOperation bop, String errmsg) {
		super(calc, errmsg, null);
		this.bop = bop;
		this.arg0 = arg0;
	}

	@Override
	public State parseLine(String line) {
		try {
			double arg1 = Double.parseDouble(line);
			try {
				double res = bop.apply(arg0, arg1);
				return new InitialState(getCalc(), null, "Result is: " + res);
			} catch (IllegalArgumentException e) {
				return new InitialState(getCalc(), "Invalid arguments: " + e.getMessage(), null);
			}
		} catch (NumberFormatException e) {
			return new HaveArgumentAndOperation(getCalc(), arg0, bop, "Invalid number: " + e.getMessage());
		}
	}

	@Override
	public String getPromptMessage() {
		return "second arg> ";
	}
	
}
