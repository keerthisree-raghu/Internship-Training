package day1;

// Question 8: Write a program to find the location of the element in the array.

public class FindElementIndex {
	public static void main(String[] args) {
		int[] elements = new int[] {7, 3, 5, 2, 9, 1};
		System.out.println("Index of element 2 is: " + findIndex(elements, 2));
		System.out.println("Index of element 8 is: " + findIndex(elements, 8));
	}
	public static int findIndex(int elements[], int target) {
		// Check if array is empty
		if(elements == null) {
			return -1;
		}
		int arrayLength = elements.length;
		// Linear search
		for(int i = 0; i < arrayLength; i++) {
			if(elements[i] == target) {
				// Index of target element
				return i;
			}
		}
	// Element not found
	return -1;
	}
}
