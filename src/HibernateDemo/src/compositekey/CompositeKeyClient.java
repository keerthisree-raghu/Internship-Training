package compositekey;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import utility.HibernateUtility;

public class CompositeKeyClient {
	public static void main(String[] args) {
		Session session = HibernateUtility.getSession();
		
		CompositeKey compkey = new CompositeKey();
		compkey.setInvoiceId(1);
		compkey.setItemId(101);
		
		Invoice invoice = new Invoice();
		invoice.setDetails("Composite Key");
		invoice.setCompkey(compkey);
		
		session.save(invoice);
		
		HibernateUtility.closeSession(null);
	}
}
