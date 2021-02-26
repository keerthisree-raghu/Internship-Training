package day9;

import java.util.Scanner;

// Write a program for four-function calculator using switch case?(add,sub,mul,div) 

public class Q31 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter first value: ");
		int val1 = scan.nextInt();
		System.out.print("Enter second value: ");
		int val2 = scan.nextInt();
		System.out.println("Choose the operation:");
		System.out.println("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division");
		int operation = scan.nextInt();
		switch(operation) {
			case 1:
				System.out.println(val1 + " + " + val2 + " = " + (val1 + val2));
				break;
			case 2:
				System.out.println(val1 + " - " + val2 + " = " + (val1 - val2));
				break;
			case 3:
				System.out.println(val1 + " * " + val2 + " = " + (val1 * val2));
				break;
			case 4: 
				System.out.println(val1 + " / " + val2 + " = " + (val1 / val2));
				break;
			default:
				System.out.println("Incorrect input: Please enter a value between 1 and 4.");
				break;
		}
	}
}
