package day9;

import java.util.Scanner;

// Write a program to find even number up to range.

public class Q33 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter lower limit of range: ");
		int start = scan.nextInt();
		System.out.print("Enter upper limit of range: ");
		int end = scan.nextInt();
		
		System.out.println("Even numbers between " + start + " and " + end + ":");
		for(int i = start; i <= end; i++) {
			if(i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
	}
}
