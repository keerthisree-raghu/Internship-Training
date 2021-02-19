package day1;

// Question 7: Write a program to sort array elements in ascending or descending order.

public class SortElements {
	public static void main(String[] args) {
		int[] elements = new int[] {7, 3, 5, 2, 9, 1};
		System.out.print("Original Array: ");
		for(int i = 0; i < elements.length; i++) {
			System.out.print(elements[i] + " ");
		}
		System.out.println();
		sortAscending(elements);
		System.out.println();
		sortDescending(elements);
	}
	// Ascending order
	public static void sortAscending(int elements[]) {
		int arrayLength = elements.length, temp = 0;
		for(int i = 0; i < arrayLength; i++) {
			for(int j = i + 1; j < arrayLength; j++) {
				if(elements[i] > elements[j]) {
					temp = elements[i];
					elements[i] = elements[j];
					elements[j] = temp;
				}
			}
		}
		System.out.print("Ascending Order: ");
		for(int i = 0; i < arrayLength; i++) {
			System.out.print(elements[i] + " ");
		}
	}
	// Descending order
	public static void sortDescending(int elements[]) {
		int arrayLength = elements.length, temp = 0;
		for(int i = 0; i < arrayLength; i++) {
			for(int j = i + 1; j < arrayLength; j++) {
				if(elements[i] < elements[j]) {
					temp = elements[i];
					elements[i] = elements[j];
					elements[j] = temp;
				}
			}
		}
		System.out.print("Descending Order: ");
		for(int i = 0; i < arrayLength; i++) {
			System.out.print(elements[i] + " ");
		}
	}
}
