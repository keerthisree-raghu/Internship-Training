package day9;

import java.util.Scanner;

// Write a program that uses a switch case to determine which season a particular month is in? 

public class Q30 {
	public static void main(String[] args) {
		System.out.print("Enter a value between 1 (January) and 12 (December): ");
		Scanner scan = new Scanner(System.in);
		int month = scan.nextInt();
		switch(month) {
			case 1:
			case 2:
			case 12:
				System.out.println("Winter");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println("Spring");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("Summer");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("Autumn");
				break;
			default:
				System.out.println("Incorrect input: Please enter a value between 1 and 12.");
				break;
		}
	}
}
