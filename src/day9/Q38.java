package day9;

import java.util.Scanner;

// Write a program to find the sum of digits of a number

public class Q38 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number: ");
		int num = scan.nextInt();
		int temp1 = 0, temp2 = 1;
		System.out.println("First " + num + " terms in the Fibonacci sequence: ");
		for(int i = 1; i <= num; ++i) {
			System.out.print(temp1 + " ");
			int sum = temp1 + temp2;
			temp1 = temp2;
			temp2 = sum;
		}
	}
}
