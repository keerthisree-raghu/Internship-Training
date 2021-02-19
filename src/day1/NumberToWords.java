package day1;

// Question 18: Write a program to convert numbers to words.

public class NumberToWords {
	public static void main(String[] args) {
		System.out.println(convertToWord(125));
	}
	// Units place values
	private static final String[] unitsPlace = {
		"",
	    " one",
	    " two",
	    " three",
	    " four",
	    " five",
	    " six",
	    " seven",
	    " eight",
	    " nine"	
	};
	// Tens place values
	private static final String[] unitsPlaceDoubles = {
		" ten",
	    " eleven",
	    " twelve",
	    " thirteen",
	    " fourteen",
	    " fifteen",
	    " sixteen",
	    " seventeen",
	    " eighteen",
	    " nineteen"		
	};
	private static final String[] tensPlace = {
		"",
	    "",
	    " twenty",
	    " thirty",
	    " forty",
	    " fifty",
	    " sixty",
	    " seventy",
	    " eighty",
	    " ninety"
	};
	private static final String[] hundredsPlace = {
		"",
	    " thousand",
	    " million",
	    " billion"
	};
	private static String convertToWord(int number) {
		String word = "";
		int index = 0;
		do {
			int num = number % 1000;
			if(num != 0) {
				String str = convertDigits(num);
				word = str + hundredsPlace[index] + word;
			}
			index++;
			number /= 1000;
		} while(number > 0);
		return word;
	}
	private static String convertDigits(int num) {
		String word = "";
		int n = num % 100;
		if(n < 10) {
			word = word + unitsPlace[n];
		}
		else if(n < 20) {
			word = word + unitsPlaceDoubles[n];
		}
		else {
			word = tensPlace[n / 10] + unitsPlace[n % 10];
		}
		word = (num / 100 > 0) ? unitsPlace[num / 100] + " hundred" + word : word;
		return word;
	}
}
