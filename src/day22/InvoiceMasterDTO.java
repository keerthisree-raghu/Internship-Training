package day22;

import java.io.Serializable;
import java.sql.Date;
//import java.time.LocalDate;

public class InvoiceMasterDTO implements Serializable {
	
	public final int getInvoiceNo() {
		return invoiceNo;
	}

	public final void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public final Date getInvoiceDate() {
		return invoiceDate;
	}

	public final void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public final int getCustomerNumber() {
		return customerNo;
	}

	public final void setcustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	private int invoiceNo;
	private Date invoiceDate;
	private int customerNo;

	@Override
	public String toString() {
		return "InvoiceMasterDTO [invoiceNo=" + invoiceNo + ", invoiceDate=" + invoiceDate + ", customerNo=" + customerNo + "]";
	}
}