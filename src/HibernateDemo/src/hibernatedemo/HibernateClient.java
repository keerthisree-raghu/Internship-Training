package hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateClient {
	public static void main(String[] args) {
		BookDTO bookDTO = new BookDTO(1, "Java", "James", 340);
		
		Comment comment = new Comment();
		comment.setMessage("This is a comment.");
		
		bookDTO.setComment(comment);
		
		// Load configuration
		Configuration config = new Configuration();
		
		// Build session factory
		SessionFactory factory = config.configure().buildSessionFactory();
		
		// Create client-specific local cache session
		Session session = factory.openSession();
		
		// TODO: Create a HibernateUtility class with ThreadLocal to get a unique session for every thread
		
		// To make the DTO hibernate aware, ensure that save method is called
		session.save(bookDTO);
		
		session.beginTransaction().commit();
	}
}
