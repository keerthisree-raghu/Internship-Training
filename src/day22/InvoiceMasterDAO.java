package day22;

import java.util.Set;

public interface InvoiceMasterDAO {
	public int insertInvoice(InvoiceMasterDTO invoiceMasterDTO) throws Exception;

	public int deleteInvoice(int invoiceNo) throws Exception;

	public int updateInvoice(InvoiceMasterDTO invoiceMasterDTO) throws Exception;

	public InvoiceMasterDTO getInvoiceMaster(int invoiceNo) throws Exception;

	public Set<InvoiceMasterDTO> getInvoiceMasterAll() throws Exception;
}