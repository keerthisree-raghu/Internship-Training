package InterfacesExercises;

import day8.FourWheeler;

public class Q7 {
	public static void main(String[] args) {
		Car car = new Car();
		car.getWheels();
	}
}

class Car extends FourWheeler {
	@Override
	public void getWheels() {
		System.out.println("A car has four wheels.");
	}
}