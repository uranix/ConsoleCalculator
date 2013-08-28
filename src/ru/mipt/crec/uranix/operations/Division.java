package ru.mipt.crec.uranix.operations;

public class Division implements BinaryOperation {

	@Override
	public String getSignature() {
		return "/";
	}

	@Override
	public double apply(double arg0, double arg1) throws IllegalArgumentException {
		if (arg1 == 0)
			throw new IllegalArgumentException("Division by zero");
		return arg0 / arg1;
	}

	
}
