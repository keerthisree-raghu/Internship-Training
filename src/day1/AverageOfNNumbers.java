package day1;

// Question 4: Write a program to calculate average of n numbers using a separate function other than main.

public class AverageOfNNumbers {
	public static void main(String[] args) {
		int n = 10;
		System.out.println("Average of " + n + " numbers is: " + calculateAverage(n));
	}
	public static double calculateAverage(int n) {
		double sum = 0.0, average = 0.0;
		// Calculate sum
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		// Calculate average
		average = sum / n;
		return average;
	}
}
