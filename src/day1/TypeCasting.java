package day1;

// Question 3: Write a program to declare all primitive data types with all possible types of initialization and also check implicit and explicity type casting by assigning them to each other.

public class TypeCasting {
	public static void main(String[] args) {
		// Implicit Type Casting
		byte b = 10;
		short s = b;
		int i = s;
		long l = i;
		float f = l;
		double d = f;
		
		System.out.println("Implicit Type Casting");
		System.out.println("Byte: " + b);
		System.out.println("Short: " + s);
		System.out.println("Integer: " + i);
		System.out.println("Long: " + l);
		System.out.println("Float: " + f);
		System.out.println("Double: " + d);
		
		System.out.println();
		
		// Explicity Type Casting
		byte by = 10;
		short sh = by;
		int in = sh;
		long lo = in;
		float fl = lo;
		double dou = fl;
		
		System.out.println("Explicit Type Casting");
		System.out.println("Byte: " + by);
		System.out.println("Short: " + sh);
		System.out.println("Integer: " + in);
		System.out.println("Long: " + lo);
		System.out.println("Float: " + fl);
		System.out.println("Double: " + dou);
		
	}
}
