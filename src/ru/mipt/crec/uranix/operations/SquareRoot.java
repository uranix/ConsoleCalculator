package ru.mipt.crec.uranix.operations;

public class SquareRoot implements UnaryOperation {

	@Override
	public String getSignature() {
		return "sqrt";
	}

	@Override
	public double apply(double arg) throws IllegalArgumentException {
		if (arg < 0)
			throw new IllegalArgumentException("Negative value for square root");
		return Math.sqrt(arg);
	}

}
