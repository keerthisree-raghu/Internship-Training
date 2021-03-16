package day22;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Set;

import day21.DBUtility;

public class InvoiceMasterDAOImpl implements InvoiceMasterDAO {
	@Override
	public int insertInvoice(InvoiceMasterDTO invoiceMasterDTO) throws Exception {
		int invoiceNumber = invoiceMasterDTO.getInvoiceNo();
		Date invoiceDate = invoiceMasterDTO.getInvoiceDate();
		int customerNumber = invoiceMasterDTO.getCustomerNumber();
		
		String insertQuery = "insert into InvoiceMaster values(?, ?, ?)";

		PreparedStatement ps = DBUtility.getConnection().prepareStatement(insertQuery);

		ps.setInt(1, invoiceNumber);
		ps.setDate(2, invoiceDate);
		ps.setInt(3, customerNumber);

		int rowsInserted = ps.executeUpdate();

		System.out.println("Inserted " + rowsInserted + " rows.");
		return 0;
	}

	@Override
	public int deleteInvoice(int invoiceNo) throws Exception {
		String deleteQuery = "delete from InvoiceMaster where invoiceNo = ?;";
		PreparedStatement ps = DBUtility.getConnection().prepareStatement(deleteQuery);
		ps.setInt(1, invoiceNo);
		int rowsDeleted = ps.executeUpdate();
		System.out.println("Deleted invoice number " + invoiceNo + "\n" + rowsDeleted + " rows deleted.");
		return 0;
	}

	@Override
	public int updateInvoice(InvoiceMasterDTO invoiceMasterDTO) throws Exception {
		int invoiceNumber = invoiceMasterDTO.getInvoiceNo();
		Date invoiceDate = invoiceMasterDTO.getInvoiceDate();
		int customerNumber = invoiceMasterDTO.getCustomerNumber();

		String updateQuery = "update InvoiceMaster set invoiceNo = ?, invoiceDate = ?, customerNo = ?;";
		PreparedStatement ps = DBUtility.getConnection().prepareStatement(updateQuery);

		ps.setInt(1, invoiceNumber);
		ps.setDate(2, invoiceDate);
		ps.setInt(3, customerNumber);

		int rowsUpdated = ps.executeUpdate();

		System.out.println(rowsUpdated + " rows updated.");

		return 0;
	}

	@Override
	public InvoiceMasterDTO getInvoiceMaster(int invoiceNo) throws Exception {
		String selectRowQuery = "select * from InvoiceMaster where invoiceNo = ?;";

		PreparedStatement ps = DBUtility.getConnection().prepareStatement(selectRowQuery);

		ps.setInt(1, invoiceNo);

		ResultSet rs = ps.executeQuery();

		ResultSetMetaData rsMeta = rs.getMetaData();
		int columns = rsMeta.getColumnCount();

		for (int i = 1; i <= columns; i++) {
			System.out.print(rsMeta.getColumnName(i) + "\t");
		}

		System.out.println();

		while (rs.next()) {
			for (int i = 1; i <= columns; i++) {
				System.out.print(rs.getString(i) + "\t");
			}
			System.out.println();
		}
		return null;
	}

	@Override
	public Set<InvoiceMasterDTO> getInvoiceMasterAll() throws Exception {
		String selectAllQuery = "select * from InvoiceMaster;";

		Statement s = DBUtility.getConnection().createStatement();

		ResultSet rs = s.executeQuery(selectAllQuery);

		ResultSetMetaData rsMeta = rs.getMetaData();
		int columns = rsMeta.getColumnCount();

		for (int i = 1; i <= columns; i++) {
			System.out.print(rsMeta.getColumnName(i) + "\t");
		}
		System.out.println();

		while (rs.next()) {
			for (int i = 1; i <= columns; i++) {
				System.out.print(rs.getString(i) + "\t");
			}
			System.out.println();
		}
		return null;
	}
}