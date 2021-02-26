package day9;

import java.util.Scanner;

// Write multiplication tables using do-while loop

public class Q39 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number: ");
		int num = scan.nextInt();
		int i = 1;
		do {
			System.out.printf("%d * %d = %d\n", num, i, num * i);
			i++;
		} while(i <= 10);
	}
}
