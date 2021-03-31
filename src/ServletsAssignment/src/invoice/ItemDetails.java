package invoice;

public class ItemDetails {
	int itemNo;
	int itemQuantity;
	int itemPrice;
	String itemUnit;
	String itemDescription;

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String description) {
		this.itemDescription = description;
	}

	@Override
	public String toString() {
		return "ItemDetails [itemNo=" + itemNo + ", itemQuantity=" + itemQuantity + ", itemPrice=" + itemPrice + ", itemUnit="
				+ itemUnit + ", description=" + itemDescription + "]";
	}

}
