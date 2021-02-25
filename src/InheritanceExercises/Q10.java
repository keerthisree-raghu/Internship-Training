package InheritanceExercises;

/*
 * Create two classes, A and B, with default constructors (empty argument lists) that announce themselves. 
 * Inherit a new class called C from A, and create a member B inside C. Do not create a constructor for C. 
 * Create an object of class C and observe the results. 
 */

public class Q10 {
	public static void main(String[] args) {
		ClassC c = new ClassC();
	}
}

class ClassA {
	public ClassA() {
		System.out.println("This is class A");
	}
}

class ClassB {
	public ClassB() {
		System.out.println("This is class B");
	}
}

class ClassC extends ClassA {
	ClassB b = new ClassB();
}
