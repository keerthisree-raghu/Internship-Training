package invoice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class UserClient {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserId(1);
		userDTO.setUserName("John Doe");
		userDTO.setPassword("Password");
		userDTO.setFlag(0);
		
		session.save(userDTO);
		
		transaction.commit();
		
		session.close();
	}
}
