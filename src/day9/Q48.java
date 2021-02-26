package day9;

// Write a program for arithmetic operation using overloading constructors

public class Q48 {
	public static void main(String[] args) {
		ArithmeticOperations a1 = new ArithmeticOperations(3, 4);
		ArithmeticOperations a2 = new ArithmeticOperations(3.5f, 4.6f);
		ArithmeticOperations a3 = new ArithmeticOperations(3.9, 4.3);
		ArithmeticOperations a4 = new ArithmeticOperations(3, 4, 5);
	}	
}

class ArithmeticOperations {
	public ArithmeticOperations(int num1, int num2) {
		System.out.println("Sum of two integer values: " + (num1 + num2));
	}
	
	public ArithmeticOperations(float num1, float num2) {
		System.out.println("Sum of two floating point values: " + (num1 + num2));
	}
	
	public ArithmeticOperations(double num1, double num2) {
		System.out.println("Sum of two double values: " + (num1 + num2));
	}
	
	public ArithmeticOperations(int num1, int num2, int num3) {
		System.out.println("Sum of three integer values: " + (num1 + num2 + num3));
	}
}