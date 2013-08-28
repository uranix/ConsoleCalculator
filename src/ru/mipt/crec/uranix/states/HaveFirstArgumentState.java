package ru.mipt.crec.uranix.states;

import ru.mipt.crec.uranix.Calculator;
import ru.mipt.crec.uranix.operations.BinaryOperation;
import ru.mipt.crec.uranix.operations.Operation;
import ru.mipt.crec.uranix.operations.UnaryOperation;

public class HaveFirstArgumentState extends State {
	
	private double arg0;
	
	public HaveFirstArgumentState(Calculator calc, double val, String errmsg) {
		super(calc, errmsg, null);
		arg0 = val;	
	}

	@Override
	public State parseLine(String line) {
		Operation op = getCalc().getOperationBySignature(line);
		if (op == null)
			return new HaveFirstArgumentState(getCalc(), arg0, "No such operation");
		if (op instanceof UnaryOperation) {
			UnaryOperation uop = (UnaryOperation)op;
			try {
				double res = uop.apply(arg0);
				return new InitialState(getCalc(), null, "Result is: " + res);
			} catch (IllegalArgumentException e) {
				return new InitialState(getCalc(), "Invalid arguments: " + e.getMessage(), null);
			}
		}
		if (op instanceof BinaryOperation) {
			BinaryOperation bop = (BinaryOperation)op;
			return new HaveArgumentAndOperation(getCalc(), arg0, bop, null);
		}
		return new InitialState(getCalc(), "Unhandled operation interface", null);
	}
	
	@Override
	public String getPromptMessage() {
		return "operation > ";
	}	
	
}
