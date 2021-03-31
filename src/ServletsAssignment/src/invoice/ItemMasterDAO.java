package invoice;

import java.util.Set;

public interface ItemMasterDAO {
	public int insertItemDetails(ItemMasterDTO itemMasterDTO);

	public int deleteItemDetails(int itemNo);

	public int updateItemDetails(ItemMasterDTO itemMasterDTO);

	public ItemMasterDTO getItemMaster(int itemNo);

	public Set<ItemMasterDTO> getItemMasterAll(String category);
}
