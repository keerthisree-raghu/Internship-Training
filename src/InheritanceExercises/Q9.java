package InheritanceExercises;

/*
 * Create a class A. add public, private and protected member variable and methods. 
 * Create another class B which extends from A and add few members. 
 * Try to access a private ,public and protected members of a base class within a class B. observe the result
 */

public class Q9 {
	public static void main(String[] args) {
		B b = new B();
		System.out.println("Inherited " + b.publicVariable);
//		System.out.println("Inherited " + b.privateVariable); // Inherited private variable is not visible
		System.out.println("Inherited " + b.protectedVariable);
		System.out.println(b.a);
//		System.out.println(b.b); // Private variable is not visible
		System.out.println(b.c);
		b.publicMethod();
//		b.privateMethod(); // Private method is not visible
		b.protectedMethod();
	}
}

class A {
	public int publicVariable = 5;
	private int privateVariable = 6;
	protected int protectedVariable = 7;
	
	public void publicMethod() {
		System.out.println("Public method");
	}
	
	private void privateMethod() {
		System.out.println("Private method");
	}
	
	protected void protectedMethod() {
		System.out.println("Protected method");
	}
}

class B extends A {
	public int a = 10;
	private int b = 12;
	protected int c = 14;
}