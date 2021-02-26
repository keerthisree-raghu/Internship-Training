package day9;

// Write a program for arithmetic operation using method overloading?

public class Q47 {
	public static void main(String[] args) {
		Q47 q = new Q47();
		System.out.println("Sum of two integer values: " + q.add(3, 4));
		System.out.println("Sum of two floating point values: " + q.add(3.1, 4.5));
		System.out.println("Sum of two double values: " + q.add(3.156, 4.543));
		System.out.println("Sum of three integer values: " + q.add(3, 4, 5));
	}
	public int add(int num1, int num2) {
		return num1 + num2;
	}
	// Method overloading by changing the return type
	public float add(float num1, float num2) {
		return num1 + num2;
	}
	public double add(double num1, double num2) {
		return num1 + num2;
	}
	// Method overloading by changing the number of arguments
	public int add(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
}
