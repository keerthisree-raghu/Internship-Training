package manytomany;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import utility.HibernateUtility;

public class QueryClient {
	public static void main(String[] args) {
		QueryClient queryClient = new QueryClient();
		queryClient.query8();
	}

	public void query1() {
		Session session = HibernateUtility.getSession();
		Query query = session.createQuery("from Student");
		List<Student> studentList = query.list();
		for (Student student : studentList) {
			System.out.println(student.getStudentId() + ": " + student.getStudentName());
			Set<Training> trainings = student.getTrainings();
			for (Training training : trainings) {
				System.out.println(training.getTrainingId() + ": " + training.getTrainingName());
			}
		}
	}

	// Where clause and named query
	public void query2() {
		Session session = HibernateUtility.getSession();
//		Query query = session.createQuery("from Student s where s.marks > 50");
		Query query = session.getNamedQuery("myQuery");
		List<Student> studentList = query.list();
		for (Student student : studentList) {
			System.out.println(student.getStudentId() + ": " + student.getStudentName());
			Set<Training> trainings = student.getTrainings();
			for (Training training : trainings) {
				System.out.println(training.getTrainingId() + ": " + training.getTrainingName());
			}
		}
	}

	// Scalars
	public void query3() {
		Session session = HibernateUtility.getSession();
		Query query = session.createQuery("select s.studentId, s.studentName from Student s where s.marks >= 50");
		List<Object> studentList = query.list();
		for (Object student : studentList) {
			System.out.println(student.toString());
		}

		Query query2 = session.createQuery("select s.studentId, s.studentName from Student s where s.marks >= 50");
		List<Object[]> studentList2 = query2.list();
		for (Object[] student : studentList2) {
			System.out.println((Integer) student[0] + ": " + (String) student[1]);
		}
	}

	// Query parameter and multiple objects joined
	public void query4() {
		Session session = HibernateUtility.getSession();
		Query query = session.createQuery("select s.studentId, s.studentName from Student s where s.marks = :m");
		query.setParameter("m", 100);
		Iterator<Object[]> iterator = query.iterate();
		while (iterator.hasNext()) {
			Object obj[] = iterator.next();
			System.out.println(obj[0] + ": " + obj[1]);
		}
	}

	// Inner join
	public void query5() {
		Session session = HibernateUtility.getSession();
		Query query = session.createQuery(
				"select s.studentId, t.trainingName from Student s join s.trainings t with t.trainingName=:t");
		query.setParameter("t", "Java Training");
		Iterator<Object[]> obj = query.iterate();
		while (obj.hasNext()) {
			Object o[] = obj.next();
			System.out.println(o[0] + ": " + o[1]);
		}
	}

	// Outer join
	public void query6() {
		Session session = HibernateUtility.getSession();
		Query query = session.createQuery(
				"select s.studentId, t.trainingName from Student s left join s.trainings t with t.trainingName=:t");
		query.setParameter("t", "Java Training");
		Iterator<Object[]> obj = query.iterate();
		while (obj.hasNext()) {
			Object o[] = obj.next();
			System.out.println(o[0] + ": " + o[1]);
		}
	}
	
	public void query7() {
		Session session = HibernateUtility.getSession();
		Query query = session.createQuery("update Student set marks = 75");
		int updatedItems = query.executeUpdate();
		System.out.println(updatedItems + " records updated.");
		session.beginTransaction().commit();
	}
	
	public void query8() {
		Session session = HibernateUtility.getSession();
		Query query = session.createQuery("insert into BackupStudent (studentId, studentName, marks) select s.studentId, s.studentName, s.marks from Student s");
		int createObjects = query.executeUpdate();
		System.out.println(createObjects);
		session.beginTransaction().commit();
	}
}
