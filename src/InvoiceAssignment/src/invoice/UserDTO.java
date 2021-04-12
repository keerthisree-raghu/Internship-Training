package invoice;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserDTO implements Comparable<UserDTO>, Cloneable, Serializable {
	@Id
	@Column(name = "USERID", unique = true, nullable = false)
	private int userId;
	@Column(name = "USERNAME", nullable = false)
	private String userName;
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	@Column(name = "FLAG", nullable = false)
	private int flag;

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserDTO(int userId, String userName, String password, int flag) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.flag = flag;
	}

	public UserDTO getClone() {
		try {
			return (UserDTO) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", password=" + password + ", flag=" + flag
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + flag;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(UserDTO o) {
		return this.userName.compareTo(o.userName);
	}
}
