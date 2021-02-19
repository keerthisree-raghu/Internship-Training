package day1;
import java.util.Scanner;

// Question 21: Write a program using switch-case to print number of days in a month. For the month of February, check for leap year and calculate.

public class DaysInAMonth {
	private static Scanner scan;
	public static void main(String[] args) {
		int month, year;
		scan = new Scanner(System.in);
		System.out.print("Enter month number from 1 to 12: ");
		month = scan.nextInt();
		switch(month) {
			// Jan, Mar, May, Jul, Aug, Oct, Dec - 31 Days
			case 1:
		  	case 3:
			case 5: 	
			case 7:
			case 8:
			case 10:
			case 12:			  	
				System.out.println("31 Days");
			  	break;
			// Apr, Jun, Sep, Nov - 30 Days
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println("30 Days");
				break;
			case 2:
				// Feb (Leap Year) - 29 Days
				// Feb (Not Leap Year) - 28 Days
				System.out.print("Enter year: ");
				year = scan.nextInt();
				if(((year % 4 == 0) && year % 100 != 0) || (year % 400 == 0)) {
					System.out.println("29 Days");
				}
				else {
					System.out.println("28 Days");
				}
				break;
			default:
				System.out.println("Invalid month number.");
		}
	}
}
