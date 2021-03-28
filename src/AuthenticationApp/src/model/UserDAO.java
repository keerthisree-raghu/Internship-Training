package model;

import java.util.Set;

public interface UserDAO {
	public UserDTO getUserDTO(int userId);

	public Set<UserDTO> getAllUserDTO();

	public int deleteUser(int userId);

	public int updateUser(UserDTO userDTO);

	public int insertUser(UserDTO userDTO);

	public UserDTO getUserByName(String username);
}
