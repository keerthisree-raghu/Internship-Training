package service;

import model.UserDTO;

public interface LoginService {
	public boolean checkUser(String username, String password);

	public boolean checkFlag(String username);

	public int updateFlag(String username, int flag);

	public int registerUser(UserDTO userDTO);
}
