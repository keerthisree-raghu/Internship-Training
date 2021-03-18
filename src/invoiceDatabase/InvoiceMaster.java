package invoiceDatabase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class InvoiceMaster implements InvoiceMasterDAO {
	Connection conn;
	
	@Override
	public int insertInvoice(InvoiceMasterDTO invoiceMasterDTO) {
		int rowsInserted = 0;
		try {
			conn = DBUtility.getConnection();
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

			String insertQuery = "insert into InvoiceMaster values(?, ?, ?)";

			PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);

			// Invoice number
			System.out.print("Enter Invoice Number: ");
			int invoiceNumber = Integer.parseInt(input.readLine());
			invoiceMasterDTO.setInvoiceNumber(invoiceNumber);

			// Customer ID
			System.out.print("Enter Customer ID: ");
			int customerID = Integer.parseInt(input.readLine());
			invoiceMasterDTO.setCustomerID(customerID);

			// Invoice date
			invoiceMasterDTO.setInvoiceDate(LocalDate.now());

			preparedStatement.setInt(1, invoiceMasterDTO.getInvoiceNumber());
			preparedStatement.setDate(2, Date.valueOf(invoiceMasterDTO.getInvoiceDate()));
			preparedStatement.setInt(3, invoiceMasterDTO.getCustomerID());

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
	public int deleteInvoice(int invoiceNumber) {
		int rowsDeleted = 0;
		try {
			conn = DBUtility.getConnection();

			String deleteQuery = "delete from InvoiceMaster where invoiceNo = ?;";

			PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery);

			preparedStatement.setInt(1, invoiceNumber);

			rowsDeleted = preparedStatement.executeUpdate();

			DBUtility.closeConnection(null);
			preparedStatement.close();
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		System.out.println("Invoice " + invoiceNumber + " deleted.");
		return rowsDeleted;
	}

	@Override
	public int updateInvoice(InvoiceMasterDTO invoiceMasterDTO) {
		int rowsUpdated = 0;
		try {
			conn = DBUtility.getConnection();
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

			String updateQuery = "update InvoiceMaster set invoiceDate = ?, customerId = ? where invoiceNo = ?;";

			PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);

			// Invoice number
			System.out.print("Enter Invoice Number to Update: ");
			int invoiceNumber = Integer.parseInt(input.readLine());

			// Customer ID
			System.out.print("Enter Updated Customer ID: ");
			int customerID = Integer.parseInt(input.readLine());
			invoiceMasterDTO.setCustomerID(customerID);

			// Invoice date
			invoiceMasterDTO.setInvoiceDate(LocalDate.now());

			preparedStatement.setDate(1, Date.valueOf(invoiceMasterDTO.getInvoiceDate()));
			preparedStatement.setInt(2, invoiceMasterDTO.getCustomerID());
			preparedStatement.setInt(3, invoiceNumber);

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
	public InvoiceMasterDTO getInvoiceMaster(int invoiceNumber) {
		InvoiceMasterDTO invoiceMasterDTO = new InvoiceMasterDTO();
		try {
			conn = DBUtility.getConnection();

			String selectQuery = "select * from InvoiceMaster where invoiceNo = ?;";

			PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);

			preparedStatement.setInt(1, invoiceNumber);

			ResultSet resultSet = preparedStatement.executeQuery();
			ResultSetMetaData resultSetMeta = resultSet.getMetaData();
			int columns = resultSetMeta.getColumnCount();
			
			while (resultSet.next()) {
				invoiceMasterDTO.setInvoiceNumber(resultSet.getInt(1));
				invoiceMasterDTO.setInvoiceDate(resultSet.getDate(2).toLocalDate());
				invoiceMasterDTO.setCustomerID(resultSet.getInt(3));

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
		return invoiceMasterDTO;
	}

	@Override
	public Set<InvoiceMasterDTO> getInvoiceMasterAll() {
		InvoiceMasterDTO invoiceMasterDTO = new InvoiceMasterDTO();
		Set<InvoiceMasterDTO> set = null;
		try {
			conn = DBUtility.getConnection();

			set = new HashSet<InvoiceMasterDTO>();

			String selectAllQuery = "select * from InvoiceMaster;";

			Statement statement = conn.createStatement();

			ResultSet resultSet = statement.executeQuery(selectAllQuery);
			ResultSetMetaData resultSetMeta = resultSet.getMetaData();
			int columns = resultSetMeta.getColumnCount();

			while (resultSet.next()) {
				invoiceMasterDTO.setInvoiceNumber(resultSet.getInt(1));
				invoiceMasterDTO.setInvoiceDate(resultSet.getDate(2).toLocalDate());
				invoiceMasterDTO.setCustomerID(resultSet.getInt(3));

				for (int i = 1; i <= columns; i++) {
					System.out.print(resultSet.getString(i) + "\t");
				}
				System.out.println();

				set.add(invoiceMasterDTO);
			}
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			e.printStackTrace();
		}
		return set;
	}

}
