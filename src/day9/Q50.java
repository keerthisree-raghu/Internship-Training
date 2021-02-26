package day9;

// Write Example program – Inheritance and multilevel inheritance?

public class Q50 {
	public static void main(String[] args) {
		ToyotaCamry camry = new ToyotaCamry();
		camry.getVechicleType();
		camry.getManufacturer();
		camry.getModel();
		camry.getFuelTankCapacity();
	}
}

class Car {
	public void getVechicleType() {
		System.out.println("Vehicle Type: Car");
	}
}

class Toyota extends Car {
	public void getManufacturer() {
		System.out.println("Manufacturer: Toyota");
	}
}

class ToyotaCamry extends Toyota {
	public void getModel() {
		System.out.println("Model: Toyota Camry");
	}
	
	public void getFuelTankCapacity() {
		System.out.println("Fuel Tank Capacity: 50 L");
	}
}
