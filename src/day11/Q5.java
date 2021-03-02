package day11;

public class Q5 {
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
	public static void main(String[] args) throws InvalidInputException {
		try {
			validateInput(105);
		}
		finally {
			System.out.println("Executing finally block.");
		}
	}
}

/*
 * Exception in thread "main" - custom exception 
 */
