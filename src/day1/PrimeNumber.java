package day1;

// Question 4: Write a program to find whether a number is prime or not.

public class PrimeNumber {
	public static void main(String[] args) {
		int num = 15;
		boolean flag = false;
		for(int i = 2; i <= num / 2; i++) {
			// Non-prime number
			if(num % i == 0) {
				flag = true;
				break;
			}
		}
		// flag is true -> not a prime
		if(flag) {
			System.out.println(num + " is not a prime number.");
		}
		// flag is false -> prime
		else {
			System.out.println(num + " is a prime number.");
		}
	}
}
