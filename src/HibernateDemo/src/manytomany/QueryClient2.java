package manytomany;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import utility.HibernateUtility;

public class QueryClient2 {
	public static void main(String[] args) {
		QueryClient2 queryClient2 = new QueryClient2();
		queryClient2.query7();
	}

	public static void display(Criteria criteria) {
		List<Student> students = criteria.list();
		Iterator<Student> iterator = students.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getStudentName());
		}
	}

	public void query1() {
		Session session = HibernateUtility.getSession();
		Criteria criteria = session.createCriteria(Student.class);
		display(criteria);
	}

	public void query2() {
		Session session = HibernateUtility.getSession();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.addOrder(Order.desc("studentName"));
		display(criteria);
	}

	public void query3() {
		Session session = HibernateUtility.getSession();
		Criteria criteria = session.createCriteria(Student.class);
//		criteria.add(Restrictions.eq("studentName", "John"));
		criteria.add(Property.forName("studentName").eq("John"));
		Student student = (Student) criteria.uniqueResult();
		System.out.println(student.getStudentId());
	}

	public void query4() {
		Session session = HibernateUtility.getSession();
		Criteria criteria = session.createCriteria(Training.class);
		criteria.add(Restrictions.eq("s.studentName", "John"));
//		criteria.add(Property.forName("s.studentName").eq("John"));
		List<Training> trainings = criteria.list();
		Iterator<Training> iterator = trainings.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getTrainingName());
		}
	}

	public void query5() {
		Session session = HibernateUtility.getSession();
		Integer f[] = { new Integer(20), new Integer(40) };
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Property.forName("marks").in(f));
		display(criteria);
	}

	public void query6() {
		Session session = HibernateUtility.getSession();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.like("studentName", "%J").ignoreCase());
		display(criteria);
	}

	public void query7() {
		Session session = HibernateUtility.getSession();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.like("studentName", "%J").ignoreCase())
				.add(Restrictions.gt("marks", new Integer(20)));
		display(criteria);
	}

	public void query8() {
		Session session = HibernateUtility.getSession();
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.or(Restrictions.like("studentName", "%J").ignoreCase(),
				Restrictions.gt("marks", new Integer(20))));
		display(criteria);
	}

	public void query9() {
		Session session = HibernateUtility.getSession();
		DetachedCriteria dc = DetachedCriteria.forClass(Student.class);
		dc.add(Restrictions.or(Restrictions.like("studentName", "%J"), Restrictions.gt("marks", new Integer(20))));
		Criteria criteria = dc.getExecutableCriteria(session);
		display(criteria);
	}
}
