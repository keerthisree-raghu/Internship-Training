package invoiceDatabase;

import java.time.LocalDate;

public class InvoiceMasterDTO {
	private int invoiceNumber;
	private LocalDate invoiceDate;
	private int customerID;

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	@Override
	public String toString() {
		return "InvoiceMasterDTO [invoiceNumber=" + invoiceNumber + ", invoiceDate=" + invoiceDate + ", customerID="
				+ customerID + "]";
	}

}
