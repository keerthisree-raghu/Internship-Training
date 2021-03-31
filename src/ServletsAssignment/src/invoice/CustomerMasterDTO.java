package invoice;

import java.io.Serializable;

public class CustomerMasterDTO implements Serializable {
	private int customerId;
	private String customerName;
	private String customerAddress;
	private String customerEmail;
	private String customerPhone;

	public final int getCustomerId() {
		return customerId;
	}

	public final void setCustomerId(int customerno) {
		this.customerId = customerno;
	}

	public final String getCustomerName() {
		return customerName;
	}

	public final void setCustomerName(String customername) {
		this.customerName = customername;
	}

	public final String getCustomerEmail() {
		return customerEmail;
	}

	public final void setCustomerEmail(String customeremail) {
		this.customerEmail = customeremail;
	}

	public final String getCustomerPhone() {
		return customerPhone;
	}

	public final void setCustomerPhone(String customerphone) {
		this.customerPhone = customerphone;
	}

	public final String getCustomerAddress() {
		return customerAddress;
	}

	public final void setCustomerAddress(String customeraddress) {
		this.customerAddress = customeraddress;
	}

	@Override
	public String toString() {
		return "CustomerMasterDTO [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerEmail=" + customerEmail + ", customerPhone=" + customerPhone + "]";
	}
}
