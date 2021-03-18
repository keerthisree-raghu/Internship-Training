package invoiceDatabase;

import java.util.Set;

public interface ItemsDAO {
	public int insertItemDetails(ItemsDTO itemsDTO);

	public int updateItemDetails(ItemsDTO itemsDTO);

	public int deleteItemDetails(int invoiceNumber);

	public ItemsDTO getItemDetails(int invoiceNumber);

	public Set<ItemsDTO> getItemDetailsAll();
}
