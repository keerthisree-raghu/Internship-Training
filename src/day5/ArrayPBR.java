package day5;

public class ArrayPBR {
	// Arrays are pass by reference
	// If an array is passed as a parameter to a method, PBR must be justified
	public static void main(String[] args) {
		char charArray[] = {'a', 'b', 'c'};
		System.out.println("Array before passing: " + charArray[0]);
		char charArrayCopy[] = new char[3];
		// Copy arrays using System.arraycopy() method
		// Parameters - (source, source position, destination, destination position, length)
		System.arraycopy(charArray, 0, charArrayCopy, 0, charArray.length);
		acceptArray(charArrayCopy);
		// Original array is unchanged
		System.out.println("Array after passing: " + charArray[0] + " (original array)");
		// Copy of array is changed
		System.out.println("Array after passing: " + charArrayCopy[0] + " (array copy)");
	}
	public static void acceptArray(char charArrayCopy[]) {
		charArrayCopy[0] = 'z';
	}
}
