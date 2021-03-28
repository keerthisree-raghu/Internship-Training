package service;

import java.util.Properties;

import model.DBUtility;
import model.UserDAO;
import model.User;
import model.UserDTO;

public class LoginServiceImpl implements LoginService, Cloneable {
	Properties prop;

	public LoginServiceImpl(Properties prop) {
		this.prop = prop;
	}

	private static LoginServiceImpl loginServiceImpl;

	public static LoginServiceImpl getLoginServiceImpl(Properties prop) {
		if (loginServiceImpl == null) {
			loginServiceImpl = new LoginServiceImpl(prop);
			return loginServiceImpl;
		} else {
			return loginServiceImpl.createClone();
		}
	}

	public LoginServiceImpl createClone() {
		try {
			return (LoginServiceImpl) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean checkUser(String username, String password) {
		UserDAO userDAO = User.getUser(prop);
		UserDTO userDTO = userDAO.getUserByName(username);

		if (userDTO != null) {
			if (userDTO.getPassword().equalsIgnoreCase(password)) {
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean checkFlag(String username) {
		UserDAO userDAO = User.getUser(prop);
		UserDTO userDTO = userDAO.getUserByName(username);
		if (userDTO != null) {
			if (userDTO.getFlag() == 0) {
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public int updateFlag(String username, int flag) {
		UserDAO userDAO = User.getUser(prop);
		UserDTO userDTO = userDAO.getUserByName(username);
		if (userDTO != null) {
			userDTO.setFlag(flag);
			return userDAO.updateUser(userDTO);
		} else {
			return 0;
		}
	}

	@Override
	public int registerUser(UserDTO userDTO) {
		UserDAO userDAO = User.getUser(prop);
		return userDAO.insertUser(userDTO);
	}

}
