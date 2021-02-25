package InheritanceExercises;

// Write a program to add two complex number using this reference.

public class Q2 {
	double real, imaginary;
	
	public Q2(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public static void main(String[] args) {
		Q2 num1 = new Q2(2.5, 3.2);
		Q2 num2 = new Q2(3.5, 4.6);
		Q2 temp;
		
		temp = addComplex(num1, num2);
		
		System.out.printf("%.1f + %.1f", temp.real, temp.imaginary);
	}
	
	public static Q2 addComplex(Q2 num1, Q2 num2) {
		Q2 temp = new Q2(0.0, 0.0);
		temp.real = num1.real + num2.real;
		temp.imaginary = num1.imaginary + num2.imaginary;
		
		return temp;
	}
}
