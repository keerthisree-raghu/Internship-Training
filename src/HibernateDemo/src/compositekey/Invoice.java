package compositekey;

public class Invoice {
	private CompositeKey compkey;
	private String details;

	public CompositeKey getCompkey() {
		return compkey;
	}

	public void setCompkey(CompositeKey compkey) {
		this.compkey = compkey;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
