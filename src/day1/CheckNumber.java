package day1;

// Question 15b: Write a program to check if a given number is an Armstrong number, or perfect number, or palindrome, or none of these.

public class CheckNumber {
	public static void main(String[] args) {
		int num = 676;
		if(isArmstrong(num)) {
			System.out.println("Armstrong Number");
		}
		else if(isPerfect(num)) {
			System.out.println("Perfect Number");
		}
		else if(isPalindrome(num)) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("Not an Armstrong number, perfect number, or a palindrome.");
		}
	}
	// Armstrong number
	public static boolean isArmstrong(int num) {
		int originalNum = num, temp, total = 0;
		while(num > 0) {
			temp = num % 10;
			total += (temp * temp * temp);
			num /= 10;
		}
		if(total == originalNum) {
			return true;
		}
		return false;
	}
	// Perfect number
	public static boolean isPerfect(int num) {
		if(num == 1) {
			return false;
		}
		int total = 1;
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				total += i;
			}
		}
		if(total == num) {
			return true;
		}
		return false;
	}
	// Palindrome
	public static boolean isPalindrome(int num) {
		int originalNum = num;
		int rem, sum = 0;
		while(num > 0) {
			rem = num % 10;
			sum = (sum * 10) + rem;
			num /= 10;
		}
		if(originalNum == sum) {
			return true;
		}
		return false;
	}
}
