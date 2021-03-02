package day11;

import java.util.Scanner;

public class Q8 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		int sum = 0, average = 0;
		boolean exceptionOccured;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter marks:");
		do {
			try {
				exceptionOccured = false;
				for(int i = 0; i < arr.length; i++) {
					arr[i] = Integer.parseInt(scan.next());
					sum += arr[i];
				}
				average = sum / 10;
				System.out.println("Average = " + average);
			}
			catch(NumberFormatException e) {
				exceptionOccured = true;
				System.out.println("Incorrect number format.");
				System.out.println("Enter correct marks.");
			}
		} while(exceptionOccured);
	}
}
