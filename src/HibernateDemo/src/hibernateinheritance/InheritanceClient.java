package hibernateinheritance;

import org.hibernate.Session;

import utility.HibernateUtility;

public class InheritanceClient {
	public static void main(String[] args) {
		Session session = HibernateUtility.getSession();
		
		ShoeFactory factory = new ShoeFactory();
		factory.setName("Parent name");
		
		BataShoeFactory bata = new BataShoeFactory();
		bata.setName("Parent Bata");
		bata.setBataName("Bata");
		
		LakhaniShoeFactory lakhani = new LakhaniShoeFactory();
		lakhani.setName("Parent Lakhani");
		lakhani.setLakhaniName("Lakhani");
		
		session.save(factory);
		session.save(bata);
		session.save(lakhani);
		
		session.beginTransaction().commit();
	}
}
