package day9;

import java.util.Scanner;

// Write a program to find average of odd number below range?

public class Q34 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter limit of range: ");
		int limit = scan.nextInt();
		int sum = 0, count = 0;
		
		for(int i = limit; i >= 0; i--) {
			if(i % 2 != 0) {
				sum += i;
				count++;
			}
		}
		System.out.println("Average of odd numbers less than " + limit + ": " + sum / count);
	}
}
