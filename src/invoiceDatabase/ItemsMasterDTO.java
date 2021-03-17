package invoiceDatabase;

public class ItemsMasterDTO {
	private int itemNumber;
	private String itemDescription;
	private float itemPrice;
	private int itemQuantity;

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	@Override
	public String toString() {
		return "ItemsMasterDTO [itemNumber=" + itemNumber + ", itemDescription=" + itemDescription + ", itemPrice="
				+ itemPrice + ", itemQuantity=" + itemQuantity + "]";
	}

}
