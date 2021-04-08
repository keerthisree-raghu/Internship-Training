package hibernatedemo;

import java.io.Serializable;

public class Comment implements Serializable {
	private String message;

	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(String message) {
		this.message = message;
	}

	public final String getMessage() {
		return message;
	}

	public final void setMessage(String message) {
		this.message = message;
	}

}
