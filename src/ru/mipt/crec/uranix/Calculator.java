package ru.mipt.crec.uranix;

import java.io.File;
import java.io.InvalidClassException;
import java.util.HashMap;
import java.util.Scanner;

import ru.mipt.crec.uranix.operations.Operation;
import ru.mipt.crec.uranix.states.InitialState;
import ru.mipt.crec.uranix.states.State;

public class Calculator {
	private UserInput ui;
	private UserOutput uo;
	private State state;
	private HashMap<String, Operation> operations;

	public Calculator(UserInput ui, UserOutput uo) {
		this.ui = ui;
		this.uo = uo;
		
		state = new InitialState(this);
		operations = new HashMap<String, Operation>();
	}
	
	public void addOperation(Operation op) {
		operations.put(op.getSignature(), op);
	}
	
	public Operation getOperationBySignature(String sig) {
		return operations.get(sig);
	}
	
	public void readOperationsFromConfig(String configFile) throws Exception {
		Scanner config = null;
		try {
			config = new Scanner(new File(configFile));
			while (config.hasNextLine()) {
				String className = config.nextLine();
				if (className.startsWith("#") || className.equals(""))
					continue;
				Object o = Class.forName(className).newInstance();
				if (o instanceof Operation) {
					addOperation((Operation)o);
				} else
					throw new InvalidClassException("Class " + className + " doesn't implement Operation interface");
			}
		} finally {
			if (config != null)
				config.close();
		}
	}

	public void run() {
		String line;
		while (true) {
			uo.printPrompt(state.getPromptMessage());

			line = ui.getLine();
			if (line == null || "".equals(line))
				break;
			
			state = state.parseLine(line);
			
			String result = state.getResultMessage();
			String error = state.getErrorMessage();
			
			if (result != null)
				uo.print(result);
			if (error != null)
				uo.printError(error);
		}
	}

}
