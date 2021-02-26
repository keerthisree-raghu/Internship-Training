package day9;

import java.util.Scanner;

// Write a program to find sum of digits of a number.

public class Q37 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number: ");
		int num = scan.nextInt();
		System.out.println("Sum of digits in " + num + ": " + calculateSum(num));
	}
	
	public static int calculateSum(int num) {
		int sum = 0;
		while(num != 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
}
