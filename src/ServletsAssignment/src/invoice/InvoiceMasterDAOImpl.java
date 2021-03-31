package invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class InvoiceMasterDAOImpl implements InvoiceMasterDAO, Cloneable {
	private static InvoiceMasterDAOImpl invoiceMasterDAOImpl;
	private Properties prop;
	Connection conn;

	private InvoiceMasterDAOImpl(Properties prop) {
		this.prop = prop;
	}

	synchronized public static InvoiceMasterDAOImpl getInvoiceMasterDAOImpl(Properties prop) {

		if (invoiceMasterDAOImpl == null) {
			invoiceMasterDAOImpl = new InvoiceMasterDAOImpl(prop);
			return invoiceMasterDAOImpl;
		} else {
			return invoiceMasterDAOImpl.createClone();
		}
	}

	public InvoiceMasterDAOImpl createClone() {
		try {
			return (InvoiceMasterDAOImpl) super.clone();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int insertInvoice(InvoiceMasterDTO invoiceMasterDTO) {
		ResultSet rs;
		int count = 0;
		try {
			conn = DBUtility.getConnection(prop);
			String query = "insert into invoicemaster (invdate, customerno) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setDate(1, java.sql.Date.valueOf(invoiceMasterDTO.getInvoiceDate()));
			ps.setInt(2, invoiceMasterDTO.getCustomerId());
			ps.execute();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				count = rs.getInt(1);
			}
			DBUtility.closeConnection(null);
			return count;
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			return 0;
		}
	}

	@Override
	public int updateInvoice(InvoiceMasterDTO invoiceMasterDTO) {
		String query = "update invoicemaster set invdate = ?, custno = ? where invno = ?";
		try {
			conn = DBUtility.getConnection(prop);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, invoiceMasterDTO.getInvoiceDate());
			ps.setInt(2, invoiceMasterDTO.getCustomerId());
			ps.setInt(3, invoiceMasterDTO.getInvoiceNo());
			System.out.println(ps);
			ps.executeUpdate();
			conn.commit();
			DBUtility.closeConnection(null);
			return 1;
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			return 0;
		}
	}

	@Override
	public int deleteInvoice(int invoiceNo) {
		String query = "delete from invoicemaster where invno = ?";
		try {
			conn = DBUtility.getConnection(prop);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, invoiceNo);
			ps.execute();
			conn.commit();
			DBUtility.closeConnection(null);
			return 1;
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			return 0;
		}
	}

	@Override
	public InvoiceMasterDTO getInvoiceMaster(int invoiceNo) {
		InvoiceMasterDTO invoiceMasterDTO = new InvoiceMasterDTO();
		String query = "select * from invoicemaster where invno = ?";
		try {
			conn = DBUtility.getConnection(prop);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, invoiceNo);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				invoiceMasterDTO.setCustomerId(rs.getInt("customerno"));
				invoiceMasterDTO.setInvoiceDate(String.valueOf(rs.getDate("invdate")));
				invoiceMasterDTO.setInvoiceNo(rs.getInt("invno"));
			}
			DBUtility.closeConnection(null);
			return invoiceMasterDTO;
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public Set<InvoiceMasterDTO> getInvoiceMasterAll() {
		Set<InvoiceMasterDTO> invoiceDetails = new HashSet<InvoiceMasterDTO>();
		Statement stmt;
		try {
			conn = DBUtility.getConnection(prop);
			InvoiceMasterDTO invoiceMasterDTO;
			stmt = conn.createStatement();
			String query = "select * from invoicemaster";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				invoiceMasterDTO = new InvoiceMasterDTO();
				invoiceMasterDTO.setCustomerId(rs.getInt("customerno"));
				invoiceMasterDTO.setInvoiceDate(String.valueOf(rs.getDate("invdate")));
				invoiceMasterDTO.setInvoiceNo(rs.getInt("invno"));
				invoiceDetails.add(invoiceMasterDTO);
			}
			DBUtility.closeConnection(null);
			return invoiceDetails;
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public String getDate(int invoiceNo) {
		try {
			String date = "";
			conn = DBUtility.getConnection(prop);
			String query = "select invdate from invoicemaster where invoiceNo = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, invoiceNo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				date = rs.getString("invdate");
			}
			return date;

		} catch (Exception e) {
		}
		return null;
	}
}