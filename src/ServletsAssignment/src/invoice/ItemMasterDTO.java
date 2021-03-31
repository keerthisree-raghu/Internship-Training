package invoice;

import java.io.Serializable;

public class ItemMasterDTO implements Serializable {
	private int itemNo;
	private String itemDescription;
	private int itemPrice;
	private String itemUnit;
	private String category;
	private String imageURL;

	public final int getItemNo() {
		return itemNo;
	}

	public final void setItemNo(int itemno) {
		this.itemNo = itemno;
	}

	public final String getItemDescription() {
		return itemDescription;
	}

	public final void setItemDescription(String itemdescription) {
		this.itemDescription = itemdescription;
	}

	public final int getItemPrice() {
		return itemPrice;
	}

	public final void setItemPrice(int itemprice) {
		this.itemPrice = itemprice;
	}

	public final String getItemUnit() {
		return itemUnit;
	}

	public final void setItemUnit(String itemunit) {
		this.itemUnit = itemunit;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String image) {
		this.imageURL = image;
	}

	@Override
	public String toString() {
		return "ItemMasterDTO [itemNo=" + itemNo + ", itemDescription=" + itemDescription + ", itemPrice=" + itemPrice
				+ ", itemUnit=" + itemUnit + ", category=" + category + ", imageURL=" + imageURL + "]";
	}

}