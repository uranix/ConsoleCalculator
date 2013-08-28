package ru.mipt.crec.uranix.operations;

public class Sine implements UnaryOperation {

	@Override
	public String getSignature() {
		return "sin";
	}

	@Override
	public double apply(double arg) throws IllegalArgumentException {
		return Math.sin(arg);
	}

}
