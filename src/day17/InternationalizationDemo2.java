package day17;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class InternationalizationDemo2 {
	public static void main(String[] args) {
		NumberFormat numberFormatter = NumberFormat.getCurrencyInstance(new Locale("en", "US")); // language, country
		int amount = 1000023; // 10_0_0_023
		System.out.println(String.format("%s", numberFormatter.format(amount)));
		
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("en", "US"));
//		LocalDate currentDate = LocalDate.now();
//		System.out.println(dateFormatter.format(currentDate));
		Date date = new Date();
		System.out.println(dateFormatter.format(date)); 
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM-dd-YYYY", new Locale("en", "US"));
		String currentDate = LocalDate.now().format(dateTimeFormatter);
		System.out.println(currentDate);
	}
}
