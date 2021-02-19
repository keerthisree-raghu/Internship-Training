package day1;

// Question 25: Compile the following Java program.

public class Q25 {
	public static void main(String[] args) {
		System.out.println("Test protected class access.");
	}
}

//private class ProtectedClass { // Error: Illegal modifier for the class ProtectedClass; only public, abstract & final are permitted
//	String Method() {
//		return "Wow";
//	}
//}

//class derived {
//	public void useD() {
//		ProtectedClass pc = new ProtectedClass(); // Error: The constructor base is not visible
//		System.out.println("ProtectedClass says: " + pc.Method());
//	}
//}