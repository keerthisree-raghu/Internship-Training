package compositekey;

import java.io.Serializable;

public class CompositeKey  implements Serializable {
	private int invoiceId;
	private int itemId;

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

}
