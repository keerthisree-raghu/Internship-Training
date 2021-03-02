package day11;

import java.util.Scanner;

public class Q7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String numerator, denominator;
		int result = 0;
		while(true) {
			System.out.println("Enter numerator: ");
			numerator = scan.next();
			if(numerator.charAt(0) == 'q' || numerator.charAt(0) == 'Q') {
				break;
			}
			System.out.println("Enter denominator: ");
			denominator = scan.next();
			try {
				result = Integer.parseInt(numerator) / Integer.parseInt(denominator);
			}
			catch(Exception e) {
				System.out.println("Exited.");
				System.out.println(e);
			}
			System.out.println(numerator + " / " + denominator + " = " + result);
		}
	}
}
