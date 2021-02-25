package InterfacesExercises;

/*
 * Create a class in a package. Write a protected method in it.
 * From outside the package, try to call the method and see the result. 
 * Now inherit from your class and call the protected method from inside a method of your derived class.
 */

public class Q6 {
	public static void main(String[] args) {
		Inherited i = new Inherited();
		i.newMethod();
	}
	protected void method() {
		System.out.println("Protected method from InterfacesExercises package.");
	}
}

class Inherited extends Q6 {
	public void newMethod() {
		super.method();
	}
}
