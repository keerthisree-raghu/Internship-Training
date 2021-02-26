package day9;

import java.util.Scanner;

public class Q36 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		int num = scan.nextInt();
		if(isPalindromeNumber(num) == true) {
			System.out.println(num + " is a palindrome.");
		}
		else {
			System.out.println(num + " is not a palindrome.");
		}
		
		System.out.print("Enter a string: ");
		String str = scan.next();
		if(isPalindromeString(str) == true) {
			System.out.println(str + " is a palindrome.");
		}
		else {
			System.out.println(str + " is not a palindrome.");
		}
	}
	
	public static boolean isPalindromeNumber(int num) {
		int originalNum = num, reversedNum = 0, remainder;
		while(num != 0) {
			remainder = num % 10;
			reversedNum = reversedNum * 10 + remainder;
			num /= 10;
		}
		if(originalNum == reversedNum) {
			return true;
		}
		return false;
	}
	
	public static boolean isPalindromeString(String str) {
		int i = 0, j = str.length() - 1;
		while(i < j) {
			if(str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
