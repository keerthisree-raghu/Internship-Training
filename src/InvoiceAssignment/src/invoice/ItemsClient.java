package invoice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class ItemsClient {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		ItemsDTO itemsDTO = new ItemsDTO();
		
		itemsDTO.setItemId(1001);
		itemsDTO.setItemName("Rice");
		itemsDTO.setItemUnit("5 kgs");
		itemsDTO.setCategory("Grocery");
		itemsDTO.setImageURL("https://www.bigbasket.com/media/uploads/p/l/10000410_15-bb-popular-rice-raw-sona-masoori.jpg");
		
		session.save(itemsDTO);
		
		transaction.commit();
		
		session.close();
	}
}
