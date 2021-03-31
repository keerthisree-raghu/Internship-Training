package invoice;

import java.io.Serializable;
import java.util.Date;
import java.time.LocalDate;

public class InvoiceMasterDTO implements Serializable {

	private int invoiceNo;
	private String invoiceDate;
	private int customerId;
	
	public final int getInvoiceNo() {
		return invoiceNo;
	}

	public final void setInvoiceNo(int invno) {
		this.invoiceNo = invno;
	}

	public final String getInvoiceDate() {
		return invoiceDate;
	}

	public final void setInvoiceDate(String string) {
		this.invoiceDate = string;
	}

	public final int getCustomerId() {
		return customerId;
	}

	public final void setCustomerId(int customerno) {
		this.customerId = customerno;
	}

	@Override
	public String toString() {
		return "InvoiceMasterDTO [invoiceNo=" + invoiceNo + ", invoiceDate=" + invoiceDate + ", customerId=" + customerId + "]";
	}

}