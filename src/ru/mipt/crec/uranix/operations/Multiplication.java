package ru.mipt.crec.uranix.operations;

public class Multiplication implements BinaryOperation {

	@Override
	public String getSignature() {
		return "*";
	}

	@Override
	public double apply(double arg0, double arg1) throws IllegalArgumentException {
		return arg0 * arg1; 
	}

	
}
