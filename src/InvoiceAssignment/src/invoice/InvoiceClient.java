package invoice;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class InvoiceClient {
	public static void main(String[] args) {
SessionFactory sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		InvoiceDTO invoiceDTO = new InvoiceDTO();
		
		invoiceDTO.setInvoiceId(101);
		invoiceDTO.setInvoiceDate(LocalDate.now());
		invoiceDTO.setCustomerId(1);
		
		session.save(invoiceDTO);
		
		transaction.commit();
		
		session.close();
	}
}
