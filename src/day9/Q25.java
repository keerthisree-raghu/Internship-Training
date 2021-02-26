package day9;

// Write a program to find out biggest number out of three numbers using relational and short-circuit OR and AND operators? 

public class Q25 {
	public static void main(String[] args) {
		int a = 10, b = 15, c = 20;
		System.out.printf("Largest of three numbers: %d, %d, %d\n", a, b, c);
		System.out.println(findLargestNumber(a, b, c));
	}
	public static int findLargestNumber(int a, int b, int c) {
		int largest;
		if(a >= b && a >= c) {
			largest = a;
		}
		else if(b >= a && b >= c) {
			largest = b;
		}
		else {
			largest = c;
		}
		return largest;
	}
}
