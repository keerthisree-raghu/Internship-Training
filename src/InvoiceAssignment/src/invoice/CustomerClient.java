package invoice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class CustomerClient {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		CustomerDTO customerDTO = new CustomerDTO();
		
		customerDTO.setCustomerId(1);
		customerDTO.setCustomerName("John Doe");
		customerDTO.setCustomerAddress("Magnolia Street");
		customerDTO.setCustomerEmail("johndoe@gmail.com");
		customerDTO.setCustomerPhone("9876543212");
		
		session.save(customerDTO);
		
		transaction.commit();
		
		session.close();
	}
}
