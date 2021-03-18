package invoiceDatabase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Set;

public class ItemsMaster implements ItemsMasterDAO {
	Connection conn;

	@Override
	public int insertItemMasterDetails(ItemsMasterDTO itemsMasterDTO) {
		int rowsInserted = 0;
		try {
			conn = DBUtility.getConnection();
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			PreparedStatement preparedStatement = null;
			char quitKey = 'x';
			while(true) {
				System.out.println("Press any letter to enter item details. Press 'q' to exit.");
				quitKey = input.readLine().charAt(0);
				if(quitKey == 'q') {
					break;
				}
				String insertQuery = "insert into ItemsMaster values(?, ?, ?, ?)";

				preparedStatement = conn.prepareStatement(insertQuery);
				
				// Item number
				System.out.print("Enter Item Number: ");
				int itemNumber = Integer.parseInt(input.readLine());
				itemsMasterDTO.setItemNumber(itemNumber);
				
				// Item description
				System.out.print("Enter Item Description: ");
				String itemDescription = input.readLine();
				itemsMasterDTO.setItemDescription(itemDescription);
				
				// Item Price
				System.out.print("Enter " + itemDescription + " Price: ");
				float itemPrice = Float.parseFloat(input.readLine());
				itemsMasterDTO.setItemPrice(itemPrice);
				
				// Item Quantity
				System.out.print("Enter " + itemDescription + " Quantity: ");
				int itemQuantity = Integer.parseInt(input.readLine());
				itemsMasterDTO.setItemQuantity(itemQuantity);

				preparedStatement.setInt(1, itemsMasterDTO.getItemNumber());
				preparedStatement.setString(2, itemsMasterDTO.getItemDescription());
				preparedStatement.setFloat(3, itemsMasterDTO.getItemPrice());
				preparedStatement.setInt(4, itemsMasterDTO.getItemQuantity());

				rowsInserted = preparedStatement.executeUpdate();
			}
			DBUtility.closeConnection(null);
			preparedStatement.close();
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		System.out.println(rowsInserted + " rows inserted.");
		return rowsInserted;
	}

	@Override
	public int updateItemMasterDetails(ItemsMasterDTO itemsMasterDTO) {
		int rowsUpdated = 0;
		try {
			conn = DBUtility.getConnection();
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			PreparedStatement preparedStatement = null;
			char quitKey = 'x';
			while(true) {
				System.out.println("Press any letter to enter item details. Press 'q' to exit.");
				quitKey = input.readLine().charAt(0);
				if(quitKey == 'q') {
					break;
				}
				String updateQuery = "update ItemsMaster set itemDesc = ?, itemPrice = ?, itemQty = ? where itemNo = ?;";

				preparedStatement = conn.prepareStatement(updateQuery);
				
				// Item number
				System.out.print("Enter Item Number: ");
				int itemNumber = Integer.parseInt(input.readLine());
				
				// Item description
				System.out.print("Enter Item Description: ");
				String itemDescription = input.readLine();
				itemsMasterDTO.setItemDescription(itemDescription);
				
				// Item Price
				System.out.print("Enter " + itemDescription + " Price: ");
				float itemPrice = Float.parseFloat(input.readLine());
				itemsMasterDTO.setItemPrice(itemPrice);
				
				// Item Quantity
				System.out.print("Enter " + itemDescription + " Quantity: ");
				int itemQuantity = Integer.parseInt(input.readLine());
				itemsMasterDTO.setItemQuantity(itemQuantity);

				preparedStatement.setString(1, itemsMasterDTO.getItemDescription());
				preparedStatement.setFloat(2, itemsMasterDTO.getItemPrice());
				preparedStatement.setInt(3, itemsMasterDTO.getItemQuantity());
				preparedStatement.setInt(4, itemNumber);

				rowsUpdated = preparedStatement.executeUpdate();
			}
			DBUtility.closeConnection(null);
			preparedStatement.close();
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		System.out.println(rowsUpdated + " rows inserted.");
		return rowsUpdated;
	}

	@Override
	public int deleteItemMasterDetails(int itemNumber) {
		int rowsDeleted = 0;
		try {
			conn = DBUtility.getConnection();

			String deleteQuery = "delete from ItemsMaster where itemNo = ?;";

			PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);

			preparedStatement.setInt(1, itemNumber);

			rowsDeleted = preparedStatement.executeUpdate();

			DBUtility.closeConnection(null);
			preparedStatement.close();
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		System.out.println("Item " + itemNumber + " deleted.");
		return rowsDeleted;
	}

	@Override
	public ItemsMasterDTO getItemDetailsMaster(int itemNumber) {
		ItemsMasterDTO itemsMasterDTO = new ItemsMasterDTO();
		try {
			conn = DBUtility.getConnection();

			String selectQuery = "select * from ItemsMaster where itemNo = ?;";

			PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);

			preparedStatement.setInt(1, itemNumber);

			ResultSet resultSet = preparedStatement.executeQuery();
			ResultSetMetaData resultSetMeta = resultSet.getMetaData();
			int columns = resultSetMeta.getColumnCount();
			
			while (resultSet.next()) {
				itemsMasterDTO.setItemNumber(resultSet.getInt(1));
				itemsMasterDTO.setItemDescription(resultSet.getString(2));
				itemsMasterDTO.setItemPrice(resultSet.getFloat(3));
				itemsMasterDTO.setItemQuantity(resultSet.getInt(4));

				for (int i = 1; i <= columns; i++) {
					System.out.print(resultSet.getString(i) + "\t");
				}
				System.out.println();
			}
			DBUtility.closeConnection(null);
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		return itemsMasterDTO;
	}

	@Override
	public Set<ItemsMasterDTO> getItemDetailsMasterAll() {
		ItemsMasterDTO itemsMasterDTO = new ItemsMasterDTO();
		Set<ItemsMasterDTO> set = null;
		try {
			conn = DBUtility.getConnection();

			String selectAllQuery = "select * from ItemsMaster;";

			Statement statement = conn.createStatement();

			ResultSet resultSet = statement.executeQuery(selectAllQuery);
			ResultSetMetaData resultSetMeta = resultSet.getMetaData();
			int columns = resultSetMeta.getColumnCount();
			
			while (resultSet.next()) {
				itemsMasterDTO.setItemNumber(resultSet.getInt(1));
				itemsMasterDTO.setItemDescription(resultSet.getString(2));
				itemsMasterDTO.setItemPrice(resultSet.getFloat(3));
				itemsMasterDTO.setItemQuantity(resultSet.getInt(4));
				
				for (int i = 1; i <= columns; i++) {
					System.out.print(resultSet.getString(i) + "\t");
				}
				System.out.println();
			}
			DBUtility.closeConnection(null);
			statement.close();
			resultSet.close();
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		return set;
	}

}
