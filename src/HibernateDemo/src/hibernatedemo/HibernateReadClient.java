package hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateReadClient {
	public static void main(String[] args) {
		// Load configuration
		Configuration config = new Configuration();
		
		// Build session factory
		SessionFactory factory = config.configure().buildSessionFactory();
		
		// Create client-specific local cache session
		Session session = factory.openSession();
		
		// TODO: Create a HibernateUtility class with ThreadLocal to get a unique session for every thread
		
		BookDTO bookDTO = (BookDTO) session.get(BookDTO.class, Integer.valueOf(1));
		
		System.out.println(bookDTO);
		
		Comment comment = bookDTO.getComment();
		
		System.out.println(comment.getMessage());
	}
}
