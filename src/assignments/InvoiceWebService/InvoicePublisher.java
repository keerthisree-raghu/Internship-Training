package assignments.InvoiceWebService;

import javax.xml.ws.Endpoint;

public class InvoicePublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:3000/ws/invoice", new InvoiceServiceImpl());
		System.out.println("Invoice service published.");
	}
}
