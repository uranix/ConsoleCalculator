package ru.mipt.crec.uranix;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserInput ui = new UserInput(System.in);
		UserOutput uo = new UserOutput(System.out, System.err);
		Calculator calc = new Calculator(ui, uo);
		
		try {
			calc.readOperationsFromConfig("operations.cfg");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		calc.run();
	}

}
