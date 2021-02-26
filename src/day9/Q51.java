package day9;

// Write a program to print the integer value using method overriding and super keyword

public class Q51 {
	public static void main(String[] args) {
		ChildClass child = new ChildClass();
		child.printInteger();
	}
}

class ParentClass {
	int num;
	void printInteger() {
		num = 5;
		System.out.println("Parent class integer value: " + num);
	}
}

class ChildClass extends ParentClass {
	int num;
	void printInteger() {
		num = 10;
		super.printInteger();
		System.out.println("Child class integer value: " + num);
		System.out.println("Parent class integer value from child class: " + super.num);
	}
}
