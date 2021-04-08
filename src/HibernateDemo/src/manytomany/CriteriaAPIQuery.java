package manytomany;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import utility.HibernateUtility;

public class CriteriaAPIQuery {
	public static void main(String[] args) {
		// Criteria API
		Session session = HibernateUtility.getSession();
		
		Criteria criteria = session.createCriteria(Student.class);
		
		List<Student> studentList = criteria.list();
		
		for(Student student : studentList) {
			System.out.println(student.getStudentName());
		}
	}
}
