package day11;

import java.util.Scanner;

public class Q9 {
	public static void main(String[] args) throws InvalidInputException {
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
					if(arr[i] < 0) {
						throw new InvalidInputException("");
					}
					else if(arr[i] > 100) {
						throw new InvalidInputException("");
					}
					else {
						sum += arr[i];
					}
				}
				average = sum / 10;
				System.out.println("Average = " + average);
			}
			catch(Exception e) {
				exceptionOccured = true;
				System.out.println("Invalid value.");
				System.out.println("Enter correct marks.");
			}
		} while(exceptionOccured);
	}
}
