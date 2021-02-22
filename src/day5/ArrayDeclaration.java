package day5;

public class ArrayDeclaration {
	public static void main(String[] args) {
		// Single-dimensional array
		int arr[] = new int[5]; // Initialized to 0 by default
		int[] arr2 = {1, 2, 3, 4, 5}; // Initializing strongly typed values
		
		// Two-dimensional arrays
		int arr3[][] = new int[4][5]; // Size cannot be changed after it is declared
		int arr4[][] = {{1, 2, 3}, {4, 5, 6}};
		
		// Uneven multi-dimensional array
		int arr5[][] = new int[3][]; // Column is not defined
		arr5[0] = new int[2];
		arr5[1] = new int[4];
		arr5[2] = new int[3];
		int arr6[][] = {{1, 2}, {3, 4, 5}};
	}
}
