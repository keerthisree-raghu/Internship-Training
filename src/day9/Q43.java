package day9;

// Write a program to find Biggest and Lowest element of an array.

public class Q43 {
	public static void main(String[] args) {
		int arr[] = {1, 3, 2, 5, 4};
		int largest, smallest, size = arr.length;
		largest = smallest = arr[0];
		for(int i = 0; i < size; i++) {
			if(arr[i] > largest) {
				largest = arr[i];
			}
			if(arr[i] < smallest) {
				smallest = arr[i];
			}
		}
		System.out.println("The smallest element is: " + smallest);
		System.out.println("The largest element is: " + largest);
	}
}
