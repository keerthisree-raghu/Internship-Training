package model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Properties;
import java.util.Set;

public class User implements UserDAO, Cloneable {
	private static User user;
	private Properties prop;

	private User(Properties prop) {
		this.prop = prop;
	}

	synchronized public static User getUser(Properties prop) {
		if (user == null) {
			user = new User(prop);
			return user;
		} else {
			return user.createClone();
		}
	}

	public User createClone() {
		try {
			return (User) super.clone();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public UserDTO getUserDTO(int uid) {
		try {
			UserDTO userDTO = new UserDTO();
			Connection conn = DBUtility.getConnection(prop);
			PreparedStatement ps = conn.prepareStatement("select * from users where userid = ?");
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				userDTO.setUserId(rs.getInt(1));
				userDTO.setUsername(rs.getString(2));
				userDTO.setPassword(rs.getString(3));
				userDTO.setFlag(rs.getInt(4));
			}
			DBUtility.closeConnection(null);
			return userDTO;
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			return null;
		}
	}

	@Override
	public Set<UserDTO> getAllUserDTO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteUser(int uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(UserDTO userDTO) {
		try {
			Connection conn = DBUtility.getConnection(prop);
			PreparedStatement ps = conn.prepareStatement("update users set username = ?, password = ?, flag = ? where userId = ?");
			ps.setString(1, userDTO.getUsername());
			ps.setString(2, userDTO.getPassword());
			ps.setInt(3, userDTO.getFlag());
			ps.setInt(4, userDTO.getUserId());
			int count = ps.executeUpdate();
			DBUtility.closeConnection(null);
			return count;
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			return 0;
		}
	}

	@Override
	public int insertUser(UserDTO userDTO) {
		try {
			Connection conn = DBUtility.getConnection(prop);
			PreparedStatement ps = conn.prepareStatement("insert into users values (?, ?, ?, ?)");
			ps.setString(2, userDTO.getUsername());
			ps.setString(3, userDTO.getPassword());
			ps.setInt(4, userDTO.getFlag());
			ps.setInt(1, userDTO.getUserId());
			int count = ps.executeUpdate();
			DBUtility.closeConnection(null);
			return count;
		} catch (Exception e) {
			DBUtility.closeConnection(e);
			return 0;
		}
	}

	@Override
	public UserDTO getUserByName(String username) {
		try {
			UserDTO userDTO = new UserDTO();
			Connection conn = DBUtility.getConnection(prop);
			PreparedStatement ps = conn.prepareStatement("select * from users where username = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				userDTO.setUserId(rs.getInt(1));
				userDTO.setUsername(rs.getString(2));
				userDTO.setPassword(rs.getString(3));
				userDTO.setFlag(rs.getInt(4));
			}
			DBUtility.closeConnection(null);
			return userDTO;
		} catch (Exception e) {
			e.printStackTrace();
			DBUtility.closeConnection(e);
			return null;
		}
	}

	public static void main(String[] args) {
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("dbconfig.properties"));
			Class.forName(prop.getProperty("driver"));
			User user = User.getUser(prop);
			UserDTO userDTO = user.getUserByName("Jim");
//			userDTO.setUserId(1);
			userDTO.setFlag(1);
//			user.insertUser(userDTO);
			user.updateUser(userDTO);
			System.out.println(userDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
