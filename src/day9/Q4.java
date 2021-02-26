package day9;

// Write a Java program to count the letters, spaces, numbers and other characters of an input string ?

public class Q4 {
	public static void main(String[] args) {
		String str = "Aa kiu, I swd skieo 236587. GH kiu: sieo?? 25.33";
		countCharacters(str);
	}
	
	public static void countCharacters(String str) {
		char[] charArray = str.toCharArray();
		int letters = 0, spaces = 0, numbers = 0, otherChars = 0;
		int size = charArray.length;
		for(int i = 0; i < size; i++) {
			if(Character.isLetter(charArray[i])) {
				letters++;
			}
			else if(Character.isDigit(charArray[i])) {
				numbers++;
			}
			else if(Character.isSpaceChar(charArray[i])) {
				spaces++;
			}
			else {
				otherChars++;
			}
		}
		System.out.println("The string is: " + str);
		System.out.println("Number of letters: " + letters);
		System.out.println("Number of spaces: " + spaces);
		System.out.println("Number of numbers: " + numbers);
		System.out.println("Number of other characters: " + otherChars);
	}
}
