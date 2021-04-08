package onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import utility.HibernateUtility;

public class OneToManyClient {
	public static void main(String[] args) {
		Session session = HibernateUtility.getSession();
		
		Employee employee = new Employee();
		
		employee.setEmpName("Ramu");
		employee.setEmpSal(20000);
		
		Address address1 = new Address();
		address1.setCity("Chennai");
		address1.setStreet("Raja Street");
		address1.setEmployee(employee);
		
		Address address2 = new Address();
		address2.setCity("Bangalore");
		address2.setStreet("MG Street");
		address2.setEmployee(employee);
		
		Set<Address> addresses = new HashSet<Address>();
		addresses.add(address1);
		addresses.add(address2);
		
		employee.setAddresses(addresses);
		
		session.save(employee);
//		session.save(address1);
//		session.save(address2);
		
		HibernateUtility.closeSession(null);
	}
}
