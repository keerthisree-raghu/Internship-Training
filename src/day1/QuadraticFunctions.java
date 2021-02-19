package day1;
import java.util.Scanner;

// Question 24: Write a simple Java class for quadratic functions of the form f(x) = ax^2 + bx + c.

public class QuadraticFunctions {
	private static Scanner scan;
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		double a, b, c;
		System.out.println("Enter values of a, b, and c: ");
		a = scan.nextDouble();
		b = scan.nextDouble();
		c = scan.nextDouble();
		CalculateQuadratic cq = new CalculateQuadratic(a, b, c);
		cq.setValues(cq);
		cq.calculateRoots();
	}
}

class CalculateQuadratic {
	double a, b, c;
	// Constructor with no parameters
	CalculateQuadratic() {
		this.a = 2;
		this.b = 3;
		this.c = 4;
	}
	// Constructor with parameters
	CalculateQuadratic(double a, double b, double c) {
		// Get values from parameters
		this.a = a;
		this.b = b;
		this.c = c;
	}
	// Set values of a, b, and c
	public void setValues(CalculateQuadratic cq) {
		this.a = cq.a;
		this.b = cq.b;
		this.c = cq.c;
	}
	// Extractors to return values of a, b, and c
	public double getA() {
		return this.a;
	}
	public double getB() {
		return this.b;
	}
	public double getC() {
		return this.c;
	}
	
	// Compute the roots of the quadratic equation
	public void calculateRoots() {
		double a = getA(), b = getB(), c = getC();
		double root1, root2;
		// Calculate determinant
		double determinant = b * b - 4 * a * c;
		if(determinant > 0) {
			// Two real and distinct roots
		    root1 = (-b + Math.sqrt(determinant)) / (2 * a);
		    root2 = (-b - Math.sqrt(determinant)) / (2 * a);
		    System.out.println("Root 1: " + root1 + "\nRoot 2: " + root2);
		}
		else if(determinant == 0) {
			// Two real and equal roots
			root1 = root2 = -b / (2 * a);
			System.out.println("Root 1: " + root1 + "\nRoot 2: " + root2);
		}
		else {
			// Complex and distinct roots
			double real = -b / (2 * a);
			double imaginary = Math.sqrt(-determinant) / (2 * a);
			System.out.println("Root 1: " + real + "+" + imaginary);
			System.out.println("Root 2: " + real + "-" + imaginary);
		}
	}
}
