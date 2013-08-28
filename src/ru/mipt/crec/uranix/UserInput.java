package ru.mipt.crec.uranix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UserInput {
	
	private BufferedReader br;

	public UserInput(InputStream in) {
		br = new BufferedReader(new InputStreamReader(in));
	}

	public String getLine() {
		try {
			return br.readLine();
		} catch (IOException e) {
			return null;
		}
	}

}
