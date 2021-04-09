package springannotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class CompKeyClient {
	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure("hibernate.cfg.xml")
				.buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Invoice inv = new Invoice();
		CompKey ck = new CompKey();
		ck.setInv_id(1001);
		ck.setItem_id(20001);
		inv.setCompkey(ck);

		inv.setDetails("Test details");

		session.save(inv);
		session.beginTransaction().commit();
	}
}