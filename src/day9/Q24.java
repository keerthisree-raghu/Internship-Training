package day9;

// Write a Java program to find area and perimeter of a square and rectangle?

public class Q24 {
	public static void main(String[] args) {
		CalculateArea squareArea = new CalculateArea(5);
		CalculateArea rectArea = new CalculateArea(3, 4);
		CalculatePerimeter squarePerimeter = new CalculatePerimeter(5);
		CalculatePerimeter rectPerimeter = new CalculatePerimeter(3, 4);
	}
}

class CalculateArea {
	public CalculateArea(int a) {
		System.out.println("Area of a square = " + a * a);
	}
	public CalculateArea(int l, int b) {
		System.out.println("Area of a rectangle = " + l * b);
	}
}

class CalculatePerimeter {
	public CalculatePerimeter(int a) {
		System.out.println("Perimeter of a square = " + a * 4);
	}
	public CalculatePerimeter(int l, int b) {
		System.out.println("Perimeter of a rectangle = " + (l * 2) + (b * 2));
	}
}
