package day11;

public class Q4 {
	public static void validateInput(int value) throws InvalidInputException {
		if(value < 0) {
			throw new InvalidInputException("Negative values are invalid.");
		}
		else if(value > 100) {
			throw new InvalidInputException("Values greater than 100 are invalid.");
		}
		else {
			System.out.println("Result: " + (value * 2));
		}
	}
	public static void main(String[] args) {
		try {
			validateInput(-3);
		}
		catch(Exception e) {
			System.out.println("Exception occured: " + e);
		}
		finally {
			System.out.println("Executing finally block.");
		}
	}
}

class InvalidInputException extends Exception {
	InvalidInputException(String str) {
		super(str);
	}
}