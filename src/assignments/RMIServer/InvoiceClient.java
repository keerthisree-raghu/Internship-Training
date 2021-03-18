package assignments.RMIServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;

public class InvoiceClient {
	public static void main(String[] args) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Invoice invoice = (Invoice) Naming.lookup("rmi://localhost:1099/myinvoiceapp");
		System.out.println("Enter your choice:");
		System.out.println("1 -> Create new invoice");
		System.out.println("2 -> Calculate approximate delivery date");
		System.out.println("3 -> Generate invoice PDF");
		System.out.println("4 -> Generate invoice Excel");
		System.out.println("5 -> Enter new items");
		int choice = Integer.parseInt(input.readLine());
		
		System.out.print("Enter invoice number: ");
		int invoiceNumber = Integer.parseInt(input.readLine());
		
		switch(choice) {
		case 1:
			invoice.startInvoiceApp(1, invoiceNumber);
			break;
		case 2:
			invoice.startInvoiceApp(2, invoiceNumber);
			break;
		case 3:
			invoice.startInvoiceApp(3, invoiceNumber);
			break;
		case 4:
			invoice.startInvoiceApp(4, invoiceNumber);
			break;
		case 5:
			invoice.startInvoiceApp(5, invoiceNumber);
			break;
		default:
			System.out.println("Invalid choice. Enter a choice value between 1 and 5.");
		}
	}
}
