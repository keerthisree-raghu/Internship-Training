package day9;

public class Q41 {
	public static void main(String[] args) {
		numberPyramid(4);
		System.out.println();
		zeroPyramid(4);
	}
	
	public static void numberPyramid(int rows) {
		int number = 1;
		for(int i = 1; i <= rows; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(number + " ");
				++number;
			}
			System.out.println();
		}
	}
	
	public static void zeroPyramid(int rows) {
		int number = 0;
		for(int i = 1; i <= rows; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(number + " ");
			}
			System.out.println();
		}
	}
}
