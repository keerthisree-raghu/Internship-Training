package assignments.Consignment;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.stream.Collectors;
//import java.util.Scanner;


import invoiceDatabase.Customer;
import invoiceDatabase.InvoiceMaster;

public class ConsignmentTracker implements TrackParcel {
//	Scanner scan = new Scanner(System.in);

	@Override
	public String calculateArrivalDate(ConsignmentDetails details, int invoiceNumber) {
		int daysOff = 0;
	
//		System.out.print("Enter shipment date (dd/MM/yyyy): ");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		String dateShipped = scan.next();
//		LocalDate shipmentDate = LocalDate.parse(dateShipped, formatter);
//		details.setShipmentDate(shipmentDate);
//		LocalDate startDate = details.getShipmentDate();
		
		InvoiceMaster invoiceMaster = new InvoiceMaster();
		// Shipped one day after order is placed
		LocalDate shipmentDate = invoiceMaster.getInvoiceMaster(invoiceNumber).getInvoiceDate().plusDays(1);
		details.setShipmentDate(shipmentDate);
		LocalDate startDate = details.getShipmentDate();
		
//		System.out.print("Enter distance (km): ");
//		double distanceKm = scan.nextDouble();
//		details.setDistance(distanceKm);
//		double distance = details.getDistance();
		
		Customer customer = new Customer();
		int customerID = invoiceMaster.getInvoiceMaster(invoiceNumber).getCustomerID();
		String location = customer.getCustomerDetails(customerID).getCustomerAddress();
		
		double distance = 0.0;
		if(location.equalsIgnoreCase("chennai")) {
			distance = 50.0;
		}
		else if(location.equalsIgnoreCase("madurai")) {
			distance = 450.0;
		}
		else if(location.equalsIgnoreCase("trichy")) {
			distance = 330.0;
		}
		
//		System.out.print("Enter speed (km/hr): ");
//		double speedKmph = scan.nextDouble();
//		details.setSpeed(speedKmph);
//		double speed = details.getSpeed();
		
		details.setSpeed(40);
		double speed = details.getSpeed();

		int hours = (int) (distance / speed);
		int days = (int) (hours / 24);
		
		System.out.println("hours " + hours + " days " + days);

		LocalDate approxEndDate = startDate.plusDays(days);
		
		List<LocalDate> listOfDates = startDate.datesUntil(approxEndDate).collect(Collectors.toList());
		
		for(LocalDate date : listOfDates) {
			if(checkWeekend(date)) {
				daysOff++;
			}
		}
		
		String arrivalDate = formatter.format(approxEndDate.plusDays(daysOff));
		
		return "Approximate arrival date: " + arrivalDate;
	}
	
	@Override
	public boolean checkWeekend(LocalDate shipmentDate) {
		DayOfWeek day = DayOfWeek.of(shipmentDate.get(ChronoField.DAY_OF_WEEK));
		boolean isWeekend = false;
		switch (day) {
		case SATURDAY:
		case SUNDAY:
			isWeekend = true;
			break;
		default:
			isWeekend = false;
		}
		return isWeekend;
	}
}