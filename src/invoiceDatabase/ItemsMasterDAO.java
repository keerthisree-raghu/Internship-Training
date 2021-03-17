package invoiceDatabase;

import java.util.Set;

public interface ItemsMasterDAO {
	public int insertItemMasterDetails(ItemsMasterDTO itemsMasterDTO);

	public int updateItemMasterDetails(ItemsMasterDTO itemsMasterDTO);

	public int deleteItemMasterDetails(int itemNumber);

	public ItemsMasterDTO getItemDetailsMaster(int itemNumber);

	public Set<ItemsMasterDTO> getItemDetailsMasterAll();
}
