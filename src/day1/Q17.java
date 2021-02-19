package day1;

// Question 17: Write a program to test a) modify the const member b) access static member in a non-static method c) create a class with one argument constructor and try to instantiate object without parameter.

public class Q17 {
	private static int staticVariable = 0;
	public static void main(String[] args) {
		// 17.b - Access static member in non-static method
//		System.out.println(modifyStaticVariable()); // Error: Cannot make a static reference to a non-static method
//		OneArgument oa = new OneArgument(); // Error: missing argument
	}
	public void modifyConstant() {
		final int CONSTANT = 100;
		System.out.println(CONSTANT);
		// 17.a - Modify const member
//		CONSTANT += 10; // Error: Constant variable cannot be modified
	}
	public int modifyStaticVariable() {
		staticVariable++;
		return staticVariable;
	}
}
class OneArgument {
	// Constructor with a parameter
	OneArgument(int value) {
		value++;
	}
}
