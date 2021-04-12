package invoice;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEMS")
public class ItemsDTO implements Comparable<ItemsDTO>, Cloneable, Serializable {
	@Id
	@Column(name = "ITEMID", unique = true, nullable = false)
	private int itemId;
	@Column(name = "ITEMNAME", nullable = false)
	private String itemName;
	@Column(name = "ITEMUNIT", nullable = false)
	private String itemUnit;
	@Column(name = "CATEGORY", nullable = false)
	private String category;
	@Column(name = "IMAGEURL", nullable = false)
	private String imageURL;
	
	public ItemsDTO() {
		// TODO Auto-generated constructor stub
	}

	public ItemsDTO(int itemId, String itemName, String itemUnit, String category, String imageURL) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemUnit = itemUnit;
		this.category = category;
		this.imageURL = imageURL;
	}
	
	public ItemsDTO getClone() {
		try {
			return (ItemsDTO) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
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

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
	public String toString() {
		return "ItemsDTO [itemId=" + itemId + ", itemName=" + itemName + ", itemUnit=" + itemUnit + ", category="
				+ category + ", imageURL=" + imageURL + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((imageURL == null) ? 0 : imageURL.hashCode());
		result = prime * result + itemId;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemUnit == null) ? 0 : itemUnit.hashCode());
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
		ItemsDTO other = (ItemsDTO) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (imageURL == null) {
			if (other.imageURL != null)
				return false;
		} else if (!imageURL.equals(other.imageURL))
			return false;
		if (itemId != other.itemId)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemUnit == null) {
			if (other.itemUnit != null)
				return false;
		} else if (!itemUnit.equals(other.itemUnit))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(ItemsDTO o) {
		return this.itemName.compareTo(o.itemName);
	}
}
