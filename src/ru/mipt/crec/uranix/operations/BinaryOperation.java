package ru.mipt.crec.uranix.operations;

public interface BinaryOperation extends Operation {
	double apply(double arg0, double arg1) throws IllegalArgumentException;
}
