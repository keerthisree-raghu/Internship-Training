package day9;

// Write a Java program to swap two variables, Without using third variable

public class Q1 {
	public static void main(String[] args) {
		int a = 15, b = 27;
		System.out.println("Before swapping: a = " + a + " b = " + b);
		a = a + b; // a = 15 + 27 = 42
		b = a - b; // b = 42 - 27 = 15
		a = a - b; // a = 42 - 15 = 27
		System.out.println("After swapping: a = " + a + " b = " + b);
	}
}
