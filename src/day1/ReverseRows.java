package day1;

// Question 19: Write a program to reverse the elements of each row in a two dimensional array.

public class ReverseRows {
	static int rows = 3, cols = 3;
	public static void main(String[] args) {
		int arr[][] = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		reverseRowElements(arr);
	}
	public static void reverseRowElements(int arr[][]) {
		for(int i = 0; i < rows; i++) {
			int start = 0, end = rows - 1;
			// Reverse elements in each row
			while(start < end) {
				int temp = arr[i][start];
				arr[i][start] = arr[i][end];
				arr[i][end] = temp;
				// Increment start and decrement end for next swap
				start++;
				end--;
			}
		}
		// Print reversed rows in the array
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
