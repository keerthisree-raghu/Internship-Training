package day9;

public class Q44 {
	public static void main(String[] args) {
		int firstArray[] = {1, 2, 3, 4, 5};
		int secondArray[] = {6, 7, 8, 9, 10};
		int size = firstArray.length;
		System.out.println("First array before swapping:");
		for(int i = 0; i < size; i++) {
			System.out.print(firstArray[i] + " ");
		}
		System.out.println("\nSecond array before swapping:");
		for(int i = 0; i < size; i++) {
			System.out.print(secondArray[i] + " ");
		}
		
		// Swap arrays
		for(int i = 0; i < size; i++) {
			firstArray[i] = firstArray[i] + secondArray[i];
			secondArray[i] = firstArray[i] - secondArray[i];
			firstArray[i] = firstArray[i] - secondArray[i];
		}
		
		System.out.println("\nFirst array after swapping:");
		for(int i = 0; i < size; i++) {
			System.out.print(firstArray[i] + " ");
		}
		System.out.println("\nSecond array after swapping:");
		for(int i = 0; i < size; i++) {
			System.out.print(secondArray[i] + " ");
		}
	}
}
