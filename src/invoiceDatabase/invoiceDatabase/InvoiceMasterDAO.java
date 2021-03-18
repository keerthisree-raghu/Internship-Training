package invoiceDatabase;

import java.util.Set;

public interface InvoiceMasterDAO {
	public int insertInvoice(InvoiceMasterDTO invoiceMasterDTO);

	public int deleteInvoice(int invoiceNumber);

	public int updateInvoice(InvoiceMasterDTO invoiceMasterDTO);

	public InvoiceMasterDTO getInvoiceMaster(int invoiceNumber);

	public Set<InvoiceMasterDTO> getInvoiceMasterAll();
}
