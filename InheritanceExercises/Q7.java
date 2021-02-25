package InheritanceExercises;

public class Q7 {
	public static void main(String[] args) {
		FinalVariable fv = new FinalVariable();
		fv.changeValue();
		fv.displayValue();
	}
}

class FinalVariable {
	final int value = 10;
	
	public void changeValue() {
		// value = 15; // Error - A final variable cannot be modified
	}
	
	public void displayValue() {
		System.out.println(value);
	}
}