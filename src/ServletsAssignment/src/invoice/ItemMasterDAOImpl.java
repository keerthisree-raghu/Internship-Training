package invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class ItemMasterDAOImpl implements ItemMasterDAO, Cloneable {
	private static ItemMasterDAOImpl itemMasterImpl;
	private Properties prop;

	private ItemMasterDAOImpl(Properties prop) {
		this.prop = prop;
	}

	synchronized public static ItemMasterDAOImpl getItemDAOImpl(Properties prop) {

		if (itemMasterImpl == null) {
			itemMasterImpl = new ItemMasterDAOImpl(prop);
			return itemMasterImpl;
		} else {
			return itemMasterImpl.createClone();
		}
	}

	public ItemMasterDAOImpl createClone() {
		try {
			return (ItemMasterDAOImpl) super.clone();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int insertItemDetails(ItemMasterDTO itemMasterDTO) {
		try {
			String query = "insert into itemmaster (itemdescription, itemprice, itemunit) values(?, ?, ?)";
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement ps = con.prepareStatement(query);
//			ps.setInt(1, itemMasterDTO.getItemno());
			System.out.println(ps);
			ps.setString(1, itemMasterDTO.getItemDescription());
			ps.setInt(2, itemMasterDTO.getItemPrice());
			ps.setString(3, itemMasterDTO.getItemUnit());
			System.out.println(ps);
			ps.execute();
	        con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteItemDetails(int itemno) {
		ItemMasterDTO itemobj = new ItemMasterDTO();
		String query = "delete from itemmaster where itemno=?";
		try {
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, itemno);
			ps.execute();
//			connection.commit();
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public int updateItemDetails(ItemMasterDTO itemMasterDTO) {
		ItemMasterDTO itemobj = new ItemMasterDTO();
		String query = "update itemmaster set itemdescription=?,itemprice=?,itemunit=? where itemno=?";
		try {
			Connection con = DBUtility.getConnection(prop);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, itemMasterDTO.getItemDescription());
			ps.setInt(2, itemMasterDTO.getItemPrice());
			ps.setString(3, itemMasterDTO.getItemUnit());
			ps.setInt(4, itemMasterDTO.getItemNo());
			System.out.println(ps);
			ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ItemMasterDTO getItemMaster(int itemno) {
		ItemMasterDTO itemobj = new ItemMasterDTO();
		Connection con = DBUtility.getConnection(prop);
		String query = "select * from itemmasterwithimage where itemno=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, itemno);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				itemobj.setItemNo(rs.getInt("itemno"));
				itemobj.setItemDescription(rs.getString("itemdescription"));
				itemobj.setItemPrice(rs.getInt("itemprice"));
				itemobj.setItemUnit(rs.getString("itemunit"));
				itemobj.setCategory(rs.getString("category"));
				itemobj.setImageURL(rs.getString("image"));
			}

			DBUtility.closeConnection(null);
			return itemobj;
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Set<ItemMasterDTO> getItemMasterAll(String category) {
		Set<ItemMasterDTO> itemdetails = new HashSet<ItemMasterDTO>();

		Statement stmt;
		try {
			Connection con = DBUtility.getConnection(prop);
			ItemMasterDTO itemobj;
			stmt = con.createStatement();
			String query = "select * from itemmasterwithimage where category=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, category);
			ResultSet rs = ps.executeQuery();
//		System.out.println(rs);
			while (rs.next()) {
				itemobj = new ItemMasterDTO();
				itemobj.setItemNo(rs.getInt("itemno"));
				itemobj.setItemDescription(rs.getString("itemdescription"));
				itemobj.setItemPrice(rs.getInt("itemprice"));
				itemobj.setItemUnit(rs.getString("itemunit"));
				itemobj.setCategory(rs.getString("category"));
				itemobj.setImageURL(rs.getString("image"));
				itemdetails.add(itemobj);
			}
			DBUtility.closeConnection(null);
			return itemdetails;
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
			return null;
		}

	}

}
