package day9;

import java.util.Scanner;

// Write a program to determine given number is prime or not?

public class Q32 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = scan.nextInt();
		boolean flag = false;
		for(int i = 2; i <= num / 2; i++) {
			if(num % i == 0) {
				flag = true;
				break;
			}
		}
		if(flag == false) {
			System.out.println(num + " is a prime number.");
		}
		else {
			System.out.println(num + " is not a prime number.");
		}
	}
}
