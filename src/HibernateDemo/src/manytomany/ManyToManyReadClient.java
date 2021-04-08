package manytomany;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import utility.HibernateUtility;

public class ManyToManyReadClient {
	public static void main(String[] args) {
		Session session = HibernateUtility.getSession();
		
		Query query = session.createQuery("from Student");
		List<Student> list = query.list();
		Iterator<Student> iterator = list.iterator();
		while(iterator.hasNext()) {
			Student student = iterator.next();
			System.out.println(student.getStudentName());
			Set<Training> trainingSet = student.getTrainings();
			for(Training training : trainingSet) {
				System.out.println(training.getTrainingName());
			}
		}
		
		Query query2 = session.createQuery("select s.studentName from Student s");
		List<String> list2 = query2.list();
		Iterator<String> iterator2 = list2.iterator();
		while(iterator2.hasNext()) {
			System.out.println(iterator2.next());
		}
		
		Query query3 = session.createQuery("select s.studentName, s.marks from Student s");
		List<Object[]> list3 = query3.list();
		Iterator<Object[]> iterator3 = list3.iterator();
		while(iterator3.hasNext()) {
			Object obj[] = iterator3.next();
			for(Object o : obj) {
				System.out.println(o.toString());
			}
		}
		
//		Student student = (Student) session.get(Student.class, Integer.valueOf(1));
//		System.out.println(student.getStudentName());
		
//		Set<Training> set = student.getTrainings();
//		Iterator<Training> iterator = set.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
		
		HibernateUtility.closeSession(null);
	}
}
