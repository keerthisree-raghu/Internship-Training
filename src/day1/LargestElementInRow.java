package day1;

// Question 20: Write a program to find the largest element in each row of a two dimensional array.

public class LargestElementInRow {
	public static void main(String[] args) {
		int arr[][] = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		findLargestElements(arr, 3);
	}
	public static void findLargestElements(int[][] arr, int rows) {
		int i = 0, currentMax = 0;
		int[] result = new int[rows];
		while(i < rows) {
			// Find the maximum value in each row
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] > currentMax) {
					currentMax = arr[i][j];
				}
			}
			// Store the maximum value of each row in the result array
			result[i] = currentMax;
			// Reset the current max value for the next row
			currentMax = 0;
			i++;
		}
		printLargestElements(result);
	}
	// Print the largest element in each row
	private static void printLargestElements(int[] result) {
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
