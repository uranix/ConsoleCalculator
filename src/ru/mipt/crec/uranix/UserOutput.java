package ru.mipt.crec.uranix;

import java.io.PrintStream;

public class UserOutput {
	
	private PrintStream out, err;

	public UserOutput(PrintStream out, PrintStream err) {
		this.out = out;
		this.err = err;
	}

	public void printError(String string) {
		err.println(string);
		err.flush();
		out.flush();
	}
	
	public void printPrompt(String string) {
		out.print(string);
		out.flush();
	}
	
	public void print(String string) {
		out.println(string);
	}
}
