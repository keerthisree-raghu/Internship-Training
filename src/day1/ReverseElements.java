package day1;

// Question 9: Write a program to reverse elements in the array.

public class ReverseElements {
	public static void main(String[] args) {
		int[] elements = {1, 2, 3, 4, 5, 6};
		System.out.print("Original Array: ");
		for(int i = 0; i < elements.length; i++) {
			System.out.print(elements[i] + " ");
		}
		System.out.println();
		reverse(elements, elements.length);
	}
	public static void reverse(int elements[], int n) {
		int temp = 0;
		// Swap elements from left and right ends
		for(int i = 0; i < n / 2; i++) {
			temp = elements[i];
			elements[i] = elements[n - i - 1];
			elements[n - i - 1] = temp;
		}
		System.out.print("Reversed Array: ");
		for(int i = 0; i < n; i++) {
			System.out.print(elements[i] + " ");
		}
	}
}
