package ru.mipt.crec.uranix;

import ru.mipt.crec.uranix.operations.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserInput ui = new UserInput(System.in);
		UserOutput uo = new UserOutput(System.out, System.err);
		Calculator calc = new Calculator(ui, uo);
		
		calc.addOperation(new Addition());
		calc.addOperation(new Substraction());
		calc.addOperation(new Multiplication());
		calc.addOperation(new Division());
		calc.addOperation(new SquareRoot());
		calc.addOperation(new Sine());
		
		calc.run();
	}

}
