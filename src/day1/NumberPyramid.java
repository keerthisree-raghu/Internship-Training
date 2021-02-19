package day1;

// Question 11: Write a program to display a left pyramid of numbers from 1 to 10.

public class NumberPyramid {
	public static void main(String[] args) {
		int rows = 4, element = 1;
		// Print pyramid of numbers
		for(int i = 1; i <= rows; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(element + " ");
				element++;
			}
			System.out.println();
		}
	}
}
