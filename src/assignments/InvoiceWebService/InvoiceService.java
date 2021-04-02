package assignments.InvoiceWebService;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface InvoiceService {
	@WebMethod
	public void generateInvoiceMethod(int choice, int invoiceNumber);
}
