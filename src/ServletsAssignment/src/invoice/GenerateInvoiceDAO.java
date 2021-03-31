package invoice;

public interface GenerateInvoiceDAO {
	public void createXML(int invoiceNo, TotalDetails details);

	public void createPDF(int invoiceNo);

	public void createExcel(int invoiceNo, String invoiceDate);

	public void sendMail(String name, String email, int invoiceNo);

	public void sendSMS(String phoneNo, TotalDetails details);
}
