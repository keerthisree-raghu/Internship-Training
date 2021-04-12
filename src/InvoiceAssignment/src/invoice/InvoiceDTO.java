package invoice;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INVOICE")
public class InvoiceDTO implements Cloneable, Serializable {
	@Id
	@Column(name = "INVOICEID", unique = true, nullable = false)
	private int invoiceId;
	@Column(name = "INVOICEDATE", nullable = false)
	private LocalDate invoiceDate;
	@Column(name = "CUSTOMERID", nullable = false)
	private int customerId;

	public InvoiceDTO() {
		// TODO Auto-generated constructor stub
	}

	public InvoiceDTO(int invoiceId, LocalDate invoiceDate, int customerId) {
		this.invoiceId = invoiceId;
		this.invoiceDate = invoiceDate;
		this.customerId = customerId;
	}

	public InvoiceDTO getClone() {
		try {
			return (InvoiceDTO) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "InvoiceDTO [invoiceId=" + invoiceId + ", invoiceDate=" + invoiceDate + ", customerId=" + customerId
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
		result = prime * result + ((invoiceDate == null) ? 0 : invoiceDate.hashCode());
		result = prime * result + invoiceId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceDTO other = (InvoiceDTO) obj;
		if (customerId != other.customerId)
			return false;
		if (invoiceDate == null) {
			if (other.invoiceDate != null)
				return false;
		} else if (!invoiceDate.equals(other.invoiceDate))
			return false;
		if (invoiceId != other.invoiceId)
			return false;
		return true;
	}

}
