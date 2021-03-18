package invoiceDatabase;

public class ItemsDTO {
	private int invoiceNumber;
	private int itemNumber;
	private int itemUnit;

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public int getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(int itemUnit) {
		this.itemUnit = itemUnit;
	}

	@Override
	public String toString() {
		return "ItemsDAO [invoiceNumber=" + invoiceNumber + ", itemNumber=" + itemNumber + ", itemUnit=" + itemUnit
				+ "]";
	}
}
