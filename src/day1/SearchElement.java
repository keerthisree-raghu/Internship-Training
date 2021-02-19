package day1;

// Question 16: Write a program to search whether a given element is present or not and if present, display the location and how many times it occurs.

public class SearchElement {
	public static void main(String[] args) {
		int[] elements = {1, 4, 7, 1, 2, 3, 4, 5, 6};
		int target = 9;
		int count = countOccurrence(elements, target);
		System.out.println(target + " occurs " + count + " time(s)");
		if(count > 0) {
			System.out.println("The first occurrence of " + target + " is found at index " + findIndex(elements, target));
		}
	}
	// Count occurrences
	public static int countOccurrence(int elements[], int target) {
		int count = 0;
		for(int i = 0; i < elements.length; i++) {
			if(elements[i] == target) {
				count++;
			}
		}
		return count;
	}
	// Find index of first occurrence
	public static int findIndex(int elements[], int target) {
		// Linear search
		for(int i = 0; i < elements.length; i++) {
			if(elements[i] == target) {
				// Index of target element
				return i;
			}
		}
	// Element not found
	return -1;
	}
}
