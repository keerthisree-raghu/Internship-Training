package day9;

// What is the value of c and d after executing this code?

public class Q18 {
	public static void main(String[] args) {
		int a = 1, b = 2, c, d;
		c = ++b; // c = 3
		d = a++; // d = 1
		c++; // c = 4
		System.out.println("Value of c = " + c);
		System.out.println("Value of d = " + d);
	}
}
