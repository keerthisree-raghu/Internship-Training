package day9;

import java.util.Scanner;

// Write a program to determine given number is prime or not using for loop? 

public class Q40 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number: ");
		int num = scan.nextInt();
		int i = 2;
		boolean flag = false;
		while(i <= num / 2) {
			if(num % i == 0) {
				flag = true;
				break;
			}
			i++;
		}
		if(!flag) {
			System.out.println(num + " is a prime number.");
		}
		else {
			System.out.println(num + " is not a prime number.");
		}
	}
}
