package model;

import java.io.Serializable;

public class UserDTO implements Serializable {
	private int userId;
	private String username;
	private String password;
	private int flag;

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + flag;
		result = prime * result + userId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (flag != other.flag)
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	public UserDTO(int userId, String username, String password, int flag) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "LoginDTO [userId=" + userId + ", username=" + username + ", password=" + password + ", flag=" + flag
				+ "]";
	}

	public final int getUserId() {
		return userId;
	}

	public final void setUserId(int userId) {
		this.userId = userId;
	}

	public final String getUsername() {
		return username;
	}

	public final void setUsername(String username) {
		this.username = username;
	}

	public final String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public final int getFlag() {
		return flag;
	}

	public final void setFlag(int flag) {
		this.flag = flag;
	}
}
