package onetomany;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Client {
	public static void main(String[] args) throws Exception {
		// SessionFactory fac=new Configuration().configure().buildSessionFactory();

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Employee emp = new Employee();
		emp.eid = 100;
		emp.ename = "John";
		emp.esalary = 1000;

		Address add1 = new Address();
		add1.aid = 200;
		add1.street = "Raja Street";
//		add1.setEmployee(emp);

		Address add2 = new Address();
		add2.aid = 300;
		add2.street = "Rani Street";
//		add2.setEmployee(emp);

		Set set = new HashSet();
		set.add(add1);
		set.add(add2);

		emp.setAddresses(set);

		session.save(add1);
		session.save(add2);
		session.save(emp);

		tx.commit();

		emp = (Employee) session.get(Employee.class, Integer.valueOf(100));
		Collection col = emp.getAddresses();
		Iterator iter = col.iterator();
		while (iter.hasNext()) {
			Address add = (Address) iter.next();
			System.out.println(add.getStreet());
		}

	}
}
