package day1;

// Question 15a: Write a program to generate a prime number list between 1 and 100.

public class PrimeNumberList {
	public static void main(String[] args) {
		int count;
		System.out.println("Prime Numbers from 1 to 100:");
		for(int i = 1; i <= 100; i++) {
			count = 0;
			for(int j = 2; j <= i / 2; j++) {
				// Non-prime number condition
				if(i % j == 0) {
					count++;
					break;
				}
			}
			if(count == 0 && i != 1) {
				System.out.print(i + " ");
			}
		}
	}
}
