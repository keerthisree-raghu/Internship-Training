package day1;

// Question 22: Create a class with public, private, protected, and default data members and method members. Create an object of this class and see what kind of compiler messages you get when you try to access all the class members from outside this class.

public class AccessSpecifiers {
	public static void main(String[] args) {
		System.out.println("Access Specifiers");
	}
}

//Cannot be accessed in a class in another package since it is not public
class VariablesTest {
	private 	int privateVariable; // Private
	protected 	int protectedVariable; // Protected
				int noModifierVariable; // Default (No Modifier)
	public 		int publicVariable; // Public
	
	// SAME CLASS - private, no modifier, protected, public
	public void method() { // Access-specifier return-type method-name
		System.out.println(privateVariable);
		System.out.println(noModifierVariable);
		System.out.println(protectedVariable);
		System.out.println(publicVariable);
	}
}

//SAME PACKAGE, SUB CLASS - no modifier, protected, public
class ChildTest extends VariablesTest {
	public void childMethod() {
//		System.out.println(privateVariable); // Private variable not visible
		System.out.println(noModifierVariable);
		System.out.println(protectedVariable);
		System.out.println(publicVariable);
	}
}

//SAME PACKAGE, NON SUBCLASS - no modifier, protected, public
class NonChildTest {
	public void nonChildMethod() {
		// Create an object of the Test class to access its properties in a non-child class
		VariablesTest vt = new VariablesTest();
//		System.out.println(t.privateVariable); // Private variable not visible
		System.out.println(vt.noModifierVariable);
		System.out.println(vt.protectedVariable);
		System.out.println(vt.publicVariable);
	}
}

