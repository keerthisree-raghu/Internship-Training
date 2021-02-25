package InheritanceExercises;

/*
 * Create an inheritance hierarchy of Haaris:   HaarisInfotech, Haaris Technologies , Haaris Pharma     etc
 * In the base class, provide methods that are common to all Haaris, and override these in the derived classes to perform different behaviors depending on the specific type of Haaris.
 * Create an array of Haaris, fill it with different specific types of Haaris, and call your base-class methods to see what happens.
 */

public class Q12 {
	public static void main(String[] args) {
		Haaris haaris[] = new Haaris[3];
		haaris[0] = new HaarisInfotech();
		haaris[1] = new HaarisTechnologies();
		haaris[2] = new HaarisPharma();
		System.out.println("Employee count in Haaris Infotech: " + haaris[0].getEmployeeCount());
		System.out.println("Employee count in Haaris Technologies: " + haaris[1].getEmployeeCount());
		System.out.println("Employee count in Haaris Pharma: " + haaris[2].getEmployeeCount());
	}
}

abstract class Haaris {
	public abstract int getEmployeeCount();
}

class HaarisInfotech extends Haaris {
	@Override
	public int getEmployeeCount() {
		return 1500;
	}
}

class HaarisTechnologies extends Haaris {
	@Override
	public int getEmployeeCount() {
		return 1000;
	}
}

class HaarisPharma extends Haaris {
	@Override
	public int getEmployeeCount() {
		return 890;
	}
}
