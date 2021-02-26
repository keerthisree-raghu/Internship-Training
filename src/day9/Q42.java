package day9;

// Write a program to print array elements in reverse order.

public class Q42 {
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5};
		int size = arr.length;
		System.out.print("Original Array: ");
		for(int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\nReversed Array: ");
		for(int i = size - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
	}
}
