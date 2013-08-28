package ru.mipt.crec.uranix.operations;

public interface UnaryOperation extends Operation {
	double apply(double arg) throws IllegalArgumentException;
}
