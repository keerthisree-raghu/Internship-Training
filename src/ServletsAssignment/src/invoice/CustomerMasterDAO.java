package invoice;

import java.util.Set;

public interface CustomerMasterDAO {
	public int insertCustomer(CustomerMasterDTO customerMasterDTO);

	public int deleteCustomer(int customerId);

	public int updateCustomer(CustomerMasterDTO customerMasterDTO);

	public String getEmail(int customerId);

	public String getPhoneNo(int customerId);

	public CustomerMasterDTO getCustomerMaster(int customerId);

	public Set<CustomerMasterDTO> getCustomerMasterAll();
}
