package day9;

import java.util.Scanner;

// Write a program that uses a switch case to determine given character is vowel or not?

public class Q29 {
	public static void main(String[] args) {
		Boolean isVowel = false;
		System.out.print("Enter character: ");
		Scanner scan = new Scanner(System.in);
		char ch = scan.next().charAt(0);
		switch(ch) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
				isVowel = true;
				break;
		}
		if(isVowel == true) {
			System.out.println(ch + " is a vowel.");
		}
		else {
			if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				System.out.println(ch + " is a consonant.");
			}
			else {
				System.out.println(ch + " is not an alphabet.");
			}
		}
	}
}
