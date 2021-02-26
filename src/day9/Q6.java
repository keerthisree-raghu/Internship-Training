package day9;

import java.io.Console;

// Write a Java program to input and display your password. 

public class Q6 {
	public static void main(String[] args) {
		Console console;
		if((console = System.console()) != null) {
			char[] password = null;
			try {
				password = console.readPassword("Enter your password: ");
				System.out.println("Your password was: " + new String(password));
			}
			finally {
				if(password != null) {
					java.util.Arrays.fill(password, ' ');;
				}
				else {
					throw new RuntimeException("Cannot get password. No console.");
				}
			}
		}
	}
}
