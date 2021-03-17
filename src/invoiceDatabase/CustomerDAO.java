package invoiceDatabase;

import java.util.Set;

public interface CustomerDAO {
	public int insertCustomerDetails(CustomerDTO customerDTO);

	public int deleteCustomerDetails(int customerID);

	public int updateCustomerDetails(CustomerDTO customerDTO);

	public CustomerDTO getCustomerDetails(int customerID);

	public Set<CustomerDTO> getCustomerDetailsAll();
}
