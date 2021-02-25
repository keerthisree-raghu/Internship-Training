package InheritanceExercises;

/*
 * Write a program to find the cost of constructing a house creating a class called House.
 * Create 2 classes Door and window. House has instance of door and window.
 * House has member which provide information related to area of construction of door and window.
 * House delegates the responsibility of calculating the cost of door and window to the respective classes.
 */

public class Q15 {
	public static void main(String[] args) {
		Door door = new Door();
		Window window = new Window();
		House house = new House();
		int doorCost = door.calculateCost(house.doorArea);
		int windowCost = window.calculateCost(house.windowArea);
		System.out.println("Door Cost = " + doorCost);
		System.out.println("Window Cost = " + windowCost);
		int totalCost = doorCost + windowCost;
		System.out.println("Total Cost = " + totalCost);
	}
}

class House {
	int doorArea = 6, windowArea = 3;
}

class Door extends House {
	public int calculateCost(int doorArea) {
		return doorArea * 12;
	}
}

class Window extends House {
	public int calculateCost(int windowArea) {
		return windowArea * 10;
	}
}