package invoiceDatabase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Set;

public class Items implements ItemsDAO {
	Connection conn;
	
	@Override
	public int insertItemDetails(ItemsDTO itemsDTO) {
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
				String insertQuery = "insert into Items values(?, ?, ?)";

				preparedStatement = conn.prepareStatement(insertQuery);
				
				// Invoice number
				System.out.print("Enter Invoice Number: ");
				int invoiceNumber = Integer.parseInt(input.readLine());
				itemsDTO.setInvoiceNumber(invoiceNumber);

				// Item number
				System.out.print("Enter Item Number: ");
				int itemNumber = Integer.parseInt(input.readLine());
				itemsDTO.setItemNumber(itemNumber);

				// Item unit
				System.out.print("Enter Item Unit: ");
				int itemUnit = Integer.parseInt(input.readLine());
				itemsDTO.setItemNumber(itemUnit);

				preparedStatement.setInt(1, itemsDTO.getInvoiceNumber());
				preparedStatement.setInt(2, itemsDTO.getItemNumber());
				preparedStatement.setInt(3, itemsDTO.getItemUnit());

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
	public int updateItemDetails(ItemsDTO itemsDTO) {
		int rowsUpdated = 0;
		try {
			conn = DBUtility.getConnection();
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

			String updateQuery = "update Items set itemUnit = ? where invoiceNo = ? and itemNo = ?;";

			PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
			
			// Invoice number
			System.out.print("Enter Invoice Number to Update: ");
			int invoiceNumber = Integer.parseInt(input.readLine());

			// Item number
			System.out.print("Enter Item Number to Update: ");
			int itemNumber = Integer.parseInt(input.readLine());
			
			// Item unit
			System.out.print("Enter Updated Item Unit: ");
			int itemUnit = Integer.parseInt(input.readLine());
			itemsDTO.setItemNumber(itemUnit);

			preparedStatement.setInt(1, itemsDTO.getItemUnit());
			preparedStatement.setInt(2, invoiceNumber);
			preparedStatement.setInt(3, itemNumber);

			rowsUpdated = preparedStatement.executeUpdate();

			DBUtility.closeConnection(null);
			preparedStatement.close();
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		System.out.println(rowsUpdated + " rows updated.");
		return rowsUpdated;
	}

	@Override
	public int deleteItemDetails(int invoiceNumber, int itemNumber) {
		int rowsDeleted = 0;
		try {
			conn = DBUtility.getConnection();

			String deleteQuery = "delete from Items where invoiceNo = ? and itemNo = ?;";

			PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);

			preparedStatement.setInt(1, invoiceNumber);
			preparedStatement.setInt(2, itemNumber);

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
	public ItemsDTO getItemDetails(int invoiceNumber, int itemNumber) {
		ItemsDTO itemsDTO = new ItemsDTO();
		try {
			conn = DBUtility.getConnection();

			String selectQuery = "select * from Items where invoiceNo = ? and itemNo = ?;";

			PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);

			preparedStatement.setInt(1, invoiceNumber);
			preparedStatement.setInt(2, itemNumber);

			ResultSet resultSet = preparedStatement.executeQuery();
			ResultSetMetaData resultSetMeta = resultSet.getMetaData();
			int columns = resultSetMeta.getColumnCount();
			
			while (resultSet.next()) {
				itemsDTO.setInvoiceNumber(resultSet.getInt(1));
				itemsDTO.setItemNumber(resultSet.getInt(2));
				itemsDTO.setItemUnit(resultSet.getInt(3));

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
		return itemsDTO;
	}

	@Override
	public Set<ItemsDTO> getItemDetailsAll() {
		ItemsDTO itemsDTO = new ItemsDTO();
		Set<ItemsDTO> set = null;
		try {
			conn = DBUtility.getConnection();

			String selectAllQuery = "select * from Items;";

			Statement statement = conn.createStatement();

			ResultSet resultSet = statement.executeQuery(selectAllQuery);
			ResultSetMetaData resultSetMeta = resultSet.getMetaData();
			int columns = resultSetMeta.getColumnCount();
			
			while (resultSet.next()) {
				itemsDTO.setInvoiceNumber(resultSet.getInt(1));
				itemsDTO.setItemNumber(resultSet.getInt(2));
				itemsDTO.setItemUnit(resultSet.getInt(3));

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
