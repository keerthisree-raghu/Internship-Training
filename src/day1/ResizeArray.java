package day1;

// Question 6: Write a program to resize an array.

public class ResizeArray {
	public static void main(String[] args) {
		int array[] = new int[10];
		System.out.println("Size of original array: " + array.length);
		int size = 15;
		array = new int[size];
		System.out.println("Size of resized array: " + array.length);
	}
}
