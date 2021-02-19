package day1;

// Question 26: Identify the problem with the following code.

public class Q26 {
	public static void main(String[] args) {
		int i = -243;
		int j = 243;
		if(i == j); 
		/* 
		 * This statement prints irrespective of the outcome of the conditional statement
		 * The semicolon after the conditional statement terminates the statement and does not provide a statement to execute if true/false
		*/
		System.out.println("Numbers are the same.");
	}
}
