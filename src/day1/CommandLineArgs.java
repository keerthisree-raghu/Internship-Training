package day1;

// Question 12: Write a program to access command line arguments.

public class CommandLineArgs {
	public static void main(String[] args) {
		// Print all command line arguments
		for(int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}
}
