package invoice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class TransactionClient {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		TransactionDTO transactionDTO = new TransactionDTO();
		
		transactionDTO.setInvoiceId(101);
		transactionDTO.setItemId(1001);
		transactionDTO.setItemQuantity(3);
		
		session.save(transactionDTO);
		
		transaction.commit();
		
		session.close();
	}
}
