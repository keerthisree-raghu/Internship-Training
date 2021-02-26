package day9;

/* Write Java assignment statements to evaluate the following equations. 
 * Area = (pi * r^2) + (2 * pi * r)
 * Energy = mass * (acceleration * height * velocity^2 / 2)
 */

public class Q23 {
	public static void main(String[] args) {
		System.out.println("Area = " + calculateArea(5));
		System.out.println("Energy = " + calculateEnergy(3, 2, 5, 6));
	}
	public static double calculateArea(int r) {
		double pi = 3.14;
		double area = (pi * r * r) + (2 * pi * r);
		return area;
	}
	public static double calculateEnergy(int m, int a, int h, int v) {
		double energy = m * (a * h * v * v / 2);
		return energy;
	}
}
