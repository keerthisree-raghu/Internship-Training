package day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

public class CollectionsDemo {
	public static void main(String[] args) {
		
//		List<Employee> employeeList = new ArrayList<>(10);
//		employeeList.add(new Employee("John"));
//		employeeList.add(new Employee("Jim"));
//		employeeList.add(new Employee("Pam"));
//		employeeList.add(new Employee("Jenna"));

		List<Employee> employeeList = Arrays.asList(
				new Employee("John"), 
				new Employee("Jim"), 
				new Employee("Pam"),
				new Employee("Jenna"));
		
		System.out.println(employeeList);
//		System.out.println(employeeList);
		System.out.println(employeeList.get(1));
		System.out.println(employeeList.contains("Jim"));
		System.out.println("Size of List :" + employeeList.size());
		
		// Print employee names using for loop
		int size = employeeList.size();
		for (int i = 0; i < size; i++) {
			System.out.println(employeeList.get(i) + " (for loop)");
		}
		
		// Print employee names using for each loop
		for (Employee employee : employeeList) {
			System.out.println(employee + " (for-each loop)");
		}

		// Iterator will not loop through the list again without initializing the iterator
		Iterator<Employee> iter = employeeList.iterator();

		while (iter.hasNext()) {
			System.out.println("First: " + iter.next() + " (Iterator)");
		}

		// Get iterator again to loop through the list again
		iter = employeeList.iterator();
	
		while (iter.hasNext()) {
			System.out.println("Second: " + iter.next() + " (Iterator)");
		}
		
		// List Iterator will loop through the list again without initializing the iterator again
		ListIterator<Employee> listIter = employeeList.listIterator();

		while (listIter.hasNext()) {
			System.out.println("Next2: " + listIter.next() + " (List Iterator)");
		}
		while (listIter.hasPrevious()) {
			System.out.println("Previous2: " + listIter.previous() + " (List Iterator)");
		}
		
		while (listIter.hasNext()) {
			System.out.println("Next3: " + listIter.next() + " (List Iterator)");
		}
		while (listIter.hasPrevious()) {
			System.out.println("Previous3: " + listIter.previous() + " (List Iterator)");
		}

		Collections.sort(employeeList, (emp1, emp2) -> {
			return emp1.compareTo(emp2);
		});
		System.out.println(employeeList);

		Stream<Employee> s = employeeList.stream();
		
		s.filter((emp) -> emp.name.equals("John")).forEach(System.out::println);

	}
}

class Employee implements Comparable<Employee> {
	String name;
	public Employee(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee Name: " + this.name;
	}
	@Override
	public int compareTo(Employee emp) {
		return this.name.compareTo(emp.name);
	}
}

//class MyComparator implements Comparator<String>{
//	@Override
//	public int compare(String s1, String s2) {
//		return s2.compareTo(s1);
//	}
//}