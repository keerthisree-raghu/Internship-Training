package onetomany;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;

import utility.HibernateUtility;

public class OneToManyReadClient {
	public static void main(String[] args) {
		Session session = HibernateUtility.getSession();
		
		Employee employee = (Employee) session.get(Employee.class, Integer.valueOf(1));
		
		System.out.println(employee.getEmpName());
		
//		Set<Address> set = employee.getAddresses();
//		Iterator<Address> iterator = set.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
		
		HibernateUtility.closeSession(null);
	}
}
