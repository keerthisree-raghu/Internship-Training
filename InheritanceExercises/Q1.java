package InheritanceExercises;

// Write a program to prove that primitive data types are passed by value and object and arrays are passed by reference.

public class Q1 {
	public static void main(String[] args) {
		// PRIMITIVE DATA TYPES - Primitive data types are passed by value
		System.out.println("Primitive datatypes are passed by value.");
		int i = 5;
		System.out.println("Value of integer before passing: " + i);
		acceptPrimitiveDatatype(i);
		// Original value is unchanged
		System.out.println("Value of integer after passing: " + i + "\n");
		
		// ARRAYS - Arrays are passed by reference
		char charArray[] = {'a', 'b', 'c'};
		System.out.println("Array before passing: " + charArray[0]);
		acceptArray(charArray);
		// Original array is changed
		System.out.println("Array after passing: " + charArray[0] + "\n");
		
		// OBJECTS - Objects are passed by reference
		Object obj = new Object(5);
		System.out.println("Object before passing: " + obj.x);
		acceptObject(obj);
		// Original value is changed
		System.out.println("Object after passing: " + obj.x);
	}
	public static void acceptPrimitiveDatatype(int i) {
		i = 10;
	}
	public static void acceptArray(char charArrayCopy[]) {
		charArrayCopy[0] = 'z';
	}
	public static void acceptObject(Object obj) {
		obj.x = 10;
	}
}

class Object {
	int x;
	Object(int i) {
		x = i;
	}
	Object() {
		x = 0;
	}
}
