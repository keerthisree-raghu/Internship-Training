package day1;

// Question 27: Create a program that calculates how much a $14,000 investment would be worth if it increased in value by 40% during the first year, lost $1,500 in value in the second year, and increased 12% in the third year.

public class InvestmentCalculator {
	public static void main(String[] args) {
		float total = 14000.0f;
		System.out.println("Original Investment: $" + total);
		// First year - Increase by 40%
		total += (total * 0.4f);
		System.out.println("Amount after one year: $" + total);
		// Second year - Loses $1,500
		total -= 1500.0f;
		System.out.println("Amount after two years: $" + total);
		// Third year - Increase by 12%
		total += (total * 0.12f);
		System.out.println("Amount after three years: $" + total);
	}
}
