package day9;

// Write a simple program find the volume of Box using method calls

public class Q49 {
	public static void main(String[] args) {
		Box box = new Box(3, 4, 5);
		System.out.println("Volume of the box is " + box.calculateVolume() + " units.");
	}
}

class Box {
	double width, height, depth;
	
	public Box(double width, double height, double depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	
	public double calculateVolume() {
		return width * height * depth;
	}
}
