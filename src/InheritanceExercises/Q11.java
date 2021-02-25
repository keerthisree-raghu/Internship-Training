package InheritanceExercises;

/*
 * Modify above Exercise  so that A and B have constructors with arguments instead of default constructors. 
 * Write a constructor for C and perform all initialization within C’s constructor.
 */

public class Q11 {
	public static void main(String[] args) {
		ClassC2 c = new ClassC2();
	}
}

class ClassA2 {
	public ClassA2(int a) {
		System.out.println("Class A Value: " + a);
	}
}

class ClassB2 {
	public ClassB2(int b) {
		System.out.println("Class B Value: " + b);
	}
}

class ClassC2 extends ClassA2 {
	public ClassC2() {
		super(1);
		ClassB2 b = new ClassB2(5);
	}
}
