package InheritanceExercises;

// Write a program to calculate the number of object created at any point using user defined class.

public class Q5 {
	public static void main(String[] args) {
		Test t1 = new Test();
		Test t2 = new Test();
		System.out.println(Test.objectCount);
		Test t3 = new Test();
		System.out.println(Test.objectCount);
	}
}

class Test {
	static int objectCount = 0;
	
	{ objectCount++; }
	
	Test() {}
	Test(int i) {}
	Test(char c) {}
}