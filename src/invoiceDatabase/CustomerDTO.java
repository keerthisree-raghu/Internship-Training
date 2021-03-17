package invoiceDatabase;

public class CustomerDTO {
	private int customerID;
	private String customerName;
	private String customerAddress;
	private String customerEmail;
	private String customerPhone;

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerID=" + customerID + ", customerAddress=" + customerAddress
				+ ", customerEmail=" + customerEmail + ", customerPhone=" + customerPhone + "]";
	}

}
