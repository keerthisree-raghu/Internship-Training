package invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class CustomerMasterDAOImpl implements CustomerMasterDAO, Cloneable {
	private static CustomerMasterDAOImpl customerMaster;
	private Properties prop;
	Connection conn;

	private CustomerMasterDAOImpl(Properties prop) {
		this.prop = prop;
	}

	synchronized public static CustomerMasterDAOImpl getCustomerMasterDAOImpl(Properties prop) {

		if (customerMaster == null) {
			customerMaster = new CustomerMasterDAOImpl(prop);
			return customerMaster;
		} else {
			return customerMaster.createClone();
		}
	}

	public CustomerMasterDAOImpl createClone() {
		try {
			return (CustomerMasterDAOImpl) super.clone();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int insertCustomer(CustomerMasterDTO customerMasterDTO) {
		try {
			conn = DBUtility.getConnection(prop);
			String query = "insert into customermaster values(?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, customerMasterDTO.getCustomerId());
			ps.setString(2, customerMasterDTO.getCustomerName());
			ps.setString(3, customerMasterDTO.getCustomerAddress());
			ps.setString(4, customerMasterDTO.getCustomerEmail());
			ps.setString(5, customerMasterDTO.getCustomerPhone());
			ps.execute();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateCustomer(CustomerMasterDTO customerMasterDTO) {
		String query = "update customermaster set CustomerName = ?, CustomerAddress = ?, CustomerPhone = ?, CustomerEmail = ? where CustomerNo = ?";
		try {
			conn = DBUtility.getConnection(prop);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, customerMasterDTO.getCustomerName());
			ps.setString(2, customerMasterDTO.getCustomerAddress());
			ps.setString(3, customerMasterDTO.getCustomerPhone());
			ps.setString(4, customerMasterDTO.getCustomerEmail());
			ps.setInt(5, customerMasterDTO.getCustomerId());
			System.out.println(ps);
			ps.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int deleteCustomer(int custno) {
		String query = "delete from customermaster where CustomerNo = ?";
		try {
			conn = DBUtility.getConnection(prop);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, custno);
			ps.execute();
			conn.commit();
		} catch (Exception e) {
		}
		return 0;
	}

	@Override
	public CustomerMasterDTO getCustomerMaster(int custno) {
		CustomerMasterDTO customerMasterDTO = new CustomerMasterDTO();
		String query = "select * from customermaster where CustomerNo = ?";
		try {
			conn = DBUtility.getConnection(prop);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, custno);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customerMasterDTO.setCustomerId(rs.getInt("CustomerNo"));
				customerMasterDTO.setCustomerName(rs.getString("CustomerName"));
				customerMasterDTO.setCustomerEmail(rs.getString("CustomerEmail"));
				customerMasterDTO.setCustomerAddress(rs.getString("CustomerAddress"));
				customerMasterDTO.setCustomerPhone(rs.getString("CustomerPhone"));
			}
			return customerMasterDTO;
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public Set<CustomerMasterDTO> getCustomerMasterAll() {
		Set<CustomerMasterDTO> customerMaster = new HashSet<CustomerMasterDTO>();
		Statement stmt;
		try {
			conn = DBUtility.getConnection(prop);
			CustomerMasterDTO customerMasterDTO;
			stmt = conn.createStatement();
			String query = "select * from customermaster";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				customerMasterDTO = new CustomerMasterDTO();
				customerMasterDTO.setCustomerId(rs.getInt("CustomerNo"));
				customerMasterDTO.setCustomerName(rs.getString("CustomerName"));
				customerMasterDTO.setCustomerEmail(rs.getString("CustomerEmail"));
				customerMasterDTO.setCustomerAddress(rs.getString("CustomerAddress"));
				customerMasterDTO.setCustomerPhone(rs.getString("CustomerPhone"));
				customerMaster.add(customerMasterDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerMaster;
	}

	@Override
	public String getEmail(int custno) {
		try {
			conn = DBUtility.getConnection(prop);
			String email = "";
			String query = "select CustomerEmail from customermaster where CustomerNo = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, custno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				email = rs.getString("CustomerEmail");
			}
			return email;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getPhoneNo(int custno) {
		try {
			conn = DBUtility.getConnection(prop);
			String phone = "";
			String query = "select CustomerPhone from customermaster where CustomerNo = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, custno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				phone = rs.getString("CustomerPhone");
			}
			return phone;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
