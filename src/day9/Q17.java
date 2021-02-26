package day9;

// Write a program to demonstrate several assignment operators (+=, -=, *=, /=)?

public class Q17 {
	public static void main(String[] args) {
		int num = 10;
		System.out.println("Initial value of num = " + num);
		num += 1;
		System.out.println("Value of num after addition assignment = " + num + " (num + 1)");
		num -= 3;
		System.out.println("Value of num after subtraction assignment = " + num + " (num - 3)");
		num *= 4;
		System.out.println("Value of num after multiplication assignment = " + num + " (num * 4)");
		num /= 2;
		System.out.println("Value of num after division assignment = " + num + " (num / 2)");
	}
}
