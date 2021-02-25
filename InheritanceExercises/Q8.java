package InheritanceExercises;

// Write a program to create Singleton Class

public class Q8 {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		singleton.singletonMethod();
	}
}

class Singleton {
	// Static variable of type Singleton
	private static Singleton singleton = new Singleton();
	
	// Private constructor prevents instatiation of any other class 
	private Singleton() {}
	
	// Creating an instance of the singleton class
	public static Singleton getInstance() {
		return singleton;
	}
	
	protected static void singletonMethod() {
		System.out.println("Singleton example program");
	}
}
