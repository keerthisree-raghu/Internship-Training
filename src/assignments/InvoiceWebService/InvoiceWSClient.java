package assignments.InvoiceWebService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class InvoiceWSClient {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:3000/ws/invoice?wsdl");

		QName qName = new QName("http://InvoiceWebService.assignments/", "InvoiceServiceImplService");

		Service service = Service.create(url, qName);

		InvoiceService invoice = service.getPort(InvoiceService.class);
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter your choice:");
		System.out.println("1 -> Create new invoice");
		System.out.println("2 -> Calculate approximate delivery date");
		System.out.println("3 -> Generate invoice PDF");
		System.out.println("4 -> Generate invoice Excel");
		System.out.println("5 -> Enter new items");
		int choice = Integer.parseInt(input.readLine());
		
		System.out.print("Enter invoice number: ");
		int invoiceNumber = Integer.parseInt(input.readLine());
		
		invoice.generateInvoiceMethod(choice, invoiceNumber);
	}
}
