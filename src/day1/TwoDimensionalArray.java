package day1;

// Question 10: Write a program to display a two dimensional number matrix from 1 to 16.

public class TwoDimensionalArray {
	public static void main(String[] args) {
		int rows = 4, columns = 4, element = 1;
		// Display elements in 2D matrix format
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < columns; c++) {
				System.out.print(element + " ");
				element++;
			}
			System.out.println();
		}
	}
}
