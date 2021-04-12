package invoice;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION")
public class TransactionDTO implements Cloneable, Serializable {
	@Id
	@Column(name = "INVOICEID", unique = true, nullable = false)
	private int invoiceId;
	@Column(name = "ITEMID", nullable = false)
	private int itemId;
	@Column(name = "ITEMQUANTITY", nullable = false)
	private int itemQuantity;

	public TransactionDTO() {
		// TODO Auto-generated constructor stub
	}

	public TransactionDTO(int invoiceId, int itemId, int itemQuantity) {
		this.invoiceId = invoiceId;
		this.itemId = itemId;
		this.itemQuantity = itemQuantity;
	}

	public TransactionDTO getClone() {
		try {
			return (TransactionDTO) super.clone();
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

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + invoiceId;
		result = prime * result + itemId;
		result = prime * result + itemQuantity;
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
		TransactionDTO other = (TransactionDTO) obj;
		if (invoiceId != other.invoiceId)
			return false;
		if (itemId != other.itemId)
			return false;
		if (itemQuantity != other.itemQuantity)
			return false;
		return true;
	}

}
