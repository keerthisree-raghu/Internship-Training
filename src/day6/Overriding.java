package day6;

public class Overriding {
	public static void main(String[] args) {
		ParentClass parent = new ChildClass();
		parent.method();
		parent.finalMethod();
	}
}

class ParentClass {
	public void method() {
		System.out.println("Parent class method invoked.");
	}
	final void finalMethod() {
		System.out.println("Final method cannot be overriden.");
	}
}

class ChildClass extends ParentClass {
	public void method() {
		System.out.println("Child class method invoked.");
	}
}
