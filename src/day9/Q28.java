package day9;

import java.util.Scanner;

// Write a program that uses an if-else-if ladder to determine which season a particular month is in?

public class Q28 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a value between 1 (January) and 12 (December): ");
		findSeason(scan.nextInt());
	}
	
	public static void findSeason(int month) {
		if(month == 1 || month == 2 || month == 12) {
			System.out.println("Winter");
		}
		else if(month == 3 || month == 4 || month == 5) {
			System.out.println("Spring");
		}
		else if(month == 6 || month == 7 || month == 8) {
			System.out.println("Summer");
		}
		else if(month == 9 || month == 10 || month == 11) {
			System.out.println("Autumn");
		}
		else {
			System.out.println("Incorrect input: Please enter a value between 1 and 12.");
		}
	}
}
