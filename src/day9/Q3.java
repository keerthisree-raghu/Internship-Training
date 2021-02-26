package day9;

import java.util.Scanner;

// Write a program to reverse a string.

public class Q3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter input string: ");
		// Convert input string to character array
		char[] letters = scan.nextLine().toCharArray(); 
		System.out.print("Reversed string: ");
		int stringSize = letters.length;
		for(int i = stringSize - 1; i >= 0; i--) {
			System.out.print(letters[i]);
		}
	}
}
