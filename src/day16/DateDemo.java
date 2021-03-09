package day16;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DateDemo {
	public static void main(String[] args) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println("Current Date and Time: " + currentDateTime);

		LocalDate currentDate = currentDateTime.toLocalDate();
		System.out.println("Current Date: " + currentDate);
		
		LocalTime currentTime = currentDateTime.toLocalTime();
		System.out.println("Current Time: " + currentTime);
		
		Month month = currentDateTime.getMonth();
		int year = currentDateTime.getYear();
		int day = currentDateTime.getDayOfMonth();
		
		int hours = currentDateTime.getHour();
		int minutes = currentDateTime.getMinute();
		int seconds = currentDateTime.getSecond();
		
		System.out.println(day + "/" + month.getValue() + "/" + year);
		System.out.println(hours + ":" + minutes + ":" + seconds);
		
		LocalDate customDate = LocalDate.of(2018, Month.JANUARY, 1);
		System.out.println("Custom Month: " + customDate.getDayOfMonth());
		
		LocalTime customTime = LocalTime.of(10, 30, 45);
		System.out.println("Custom Time: " + customTime);
		
		LocalTime parseTime = LocalTime.parse("02:15:30");
		System.out.println("Custom Minute: " + parseTime.getMinute());
		
		// Chrono units can calculate future time/date
		LocalDate nextCentury = customDate.plus(1, ChronoUnit.CENTURIES);
		System.out.println(nextCentury);
		
		LocalDate nextMonth = customDate.plus(10, ChronoUnit.MONTHS);
		System.out.println(nextMonth);
		
		LocalTime nextTime = customTime.plus(1, ChronoUnit.HOURS);
		System.out.println(nextTime);
		
		ZonedDateTime internationalDateTime = ZonedDateTime.now();
		System.out.println(internationalDateTime);
		
		ZonedDateTime kTime = ZonedDateTime.parse("2021-03-09T14:05:10.596531800+05:30[Asia/Karachi]");
		System.out.println(kTime);
	}
}
