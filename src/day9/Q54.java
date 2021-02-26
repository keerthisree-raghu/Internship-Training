package day9;

// Write a simple interface program to print an integer value using access implementation through interface references?

public class Q54 {
	public static void main(String[] args) {
		System.out.println(MyInterface.i);
	}
}

interface MyInterface {
	int i = 5;
}