package invoice;

import java.util.Set;

public interface InvoiceMasterDAO {
	public int insertInvoice(InvoiceMasterDTO invoiceMasterDTO);

	public int deleteInvoice(int invoiceNo);

	public int updateInvoice(InvoiceMasterDTO invoiceMasterDTO);

	public InvoiceMasterDTO getInvoiceMaster(int invoiceNo);

	public Set<InvoiceMasterDTO> getInvoiceMasterAll();

	public String getDate(int invoiceNo);
}
