package invoiceDatabase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class Customer implements CustomerDAO {
	Connection conn;

	@Override
	public int insertCustomerDetails(CustomerDTO customerDTO) {
		int rowsInserted = 0;
		try {
			conn = DBUtility.getConnection();
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

			String insertQuery = "insert into Customer values(?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);

			// Customer ID
			System.out.print("Enter Customer ID: ");
			int customerID = Integer.parseInt(input.readLine());
			customerDTO.setCustomerID(customerID);

			// Customer name
			System.out.print("Enter Customer Name: ");
			String customerName = input.readLine();
			customerDTO.setCustomerName(customerName);

			// Customer address
			System.out.print("Enter Customer Address: ");
			String customerAddress = input.readLine();
			customerDTO.setCustomerAddress(customerAddress);

			// Customer email ID
			System.out.print("Enter Customer Email: ");
			String customerEmail = input.readLine();
			customerDTO.setCustomerEmail(customerEmail);

			// Customer phone number
			System.out.print("Enter Customer Phone Number: ");
			String customerPhone = input.readLine();
			customerDTO.setCustomerPhone(customerPhone);

			preparedStatement.setInt(1, customerDTO.getCustomerID());
			preparedStatement.setString(2, customerDTO.getCustomerName());
			preparedStatement.setString(3, customerDTO.getCustomerAddress());
			preparedStatement.setString(4, customerDTO.getCustomerEmail());
			preparedStatement.setString(5, customerDTO.getCustomerPhone());

			rowsInserted = preparedStatement.executeUpdate();

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
	public int deleteCustomerDetails(int customerID) {
		int rowsDeleted = 0;
		try {
			conn = DBUtility.getConnection();

			String deleteQuery = "delete from Customer where customerID = ?;";

			PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);

			preparedStatement.setInt(1, customerID);

			rowsDeleted = preparedStatement.executeUpdate();

			DBUtility.closeConnection(null);
			preparedStatement.close();
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		System.out.println("Customer " + customerID + " deleted.");
		return rowsDeleted;
	}

	@Override
	public int updateCustomerDetails(CustomerDTO customerDTO) {
		int rowsUpdated = 0;
		try {
			conn = DBUtility.getConnection();
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

			String updateQuery = "update Customer set customerName = ?, customerAddress = ?, customerEmail = ?, customerEmail = ? where customerID = ?;";

			PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);

			// Customer name
			System.out.print("Enter Updated Customer Name: ");
			String customerName = input.readLine();
			customerDTO.setCustomerName(customerName);

			// Customer address
			System.out.print("Enter Updated Customer Address: ");
			String customerAddress = input.readLine();
			customerDTO.setCustomerAddress(customerAddress);

			// Customer email ID
			System.out.print("Enter Updated Customer Email: ");
			String customerEmail = input.readLine();
			customerDTO.setCustomerEmail(customerEmail);

			// Customer phone number
			System.out.print("Enter Updated Customer Phone Number: ");
			String customerPhone = input.readLine();
			customerDTO.setCustomerPhone(customerPhone);

			preparedStatement.setInt(1, customerDTO.getCustomerID());
			preparedStatement.setString(2, customerDTO.getCustomerName());
			preparedStatement.setString(3, customerDTO.getCustomerAddress());
			preparedStatement.setString(4, customerDTO.getCustomerEmail());
			preparedStatement.setString(5, customerDTO.getCustomerPhone());

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
	public CustomerDTO getCustomerDetails(int customerID) {
		CustomerDTO customerDTO = new CustomerDTO();
		try {
			conn = DBUtility.getConnection();

			String selectQuery = "select * from Customer where customerID = ?;";

			PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);

			preparedStatement.setInt(1, customerID);

			ResultSet resultSet = preparedStatement.executeQuery();
			ResultSetMetaData resultSetMeta = resultSet.getMetaData();
			int columns = resultSetMeta.getColumnCount();
			
			while (resultSet.next()) {
				customerDTO.setCustomerID(resultSet.getInt(1));
				customerDTO.setCustomerName(resultSet.getString(2));
				customerDTO.setCustomerAddress(resultSet.getString(3));
				customerDTO.setCustomerEmail(resultSet.getString(4));
				customerDTO.setCustomerPhone(resultSet.getString(5));

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
		return customerDTO;
	}

	@Override
	public Set<CustomerDTO> getCustomerDetailsAll() {
		CustomerDTO customerDTO = new CustomerDTO();
		Set<CustomerDTO> set = null;
		try {
			conn = DBUtility.getConnection();

			set = new HashSet<CustomerDTO>();

			String selectAllQuery = "select * from Customer;";

			Statement statement = conn.createStatement();

			ResultSet resultSet = statement.executeQuery(selectAllQuery);
			ResultSetMetaData resultSetMeta = resultSet.getMetaData();
			int columns = resultSetMeta.getColumnCount();

			while (resultSet.next()) {
				customerDTO.setCustomerID(resultSet.getInt(1));
				customerDTO.setCustomerName(resultSet.getString(2));
				customerDTO.setCustomerAddress(resultSet.getString(3));
				customerDTO.setCustomerEmail(resultSet.getString(4));
				customerDTO.setCustomerPhone(resultSet.getString(5));

				for (int i = 1; i <= columns; i++) {
					System.out.print(resultSet.getString(i) + "\t");
				}
				System.out.println();

				set.add(customerDTO);
			}
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		return set;
	}

}
