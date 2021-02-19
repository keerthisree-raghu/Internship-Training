package day1;

// Question 23: 
public class ManipulateProtectedData {
	public static void main(String[] args) {
		SecondClass sc = new SecondClass();
		sc.addFive();
	}
}

class FirstClass {
	// Protected variable
	protected int protectedVariable = 5; // Protected
}

class SecondClass {
	public void addFive() {
		// Create an instance of FirstClass
		FirstClass fc = new FirstClass();
		// Manipulate protected variable from FirstClass
		System.out.println(fc.protectedVariable + 5);
	}
}
