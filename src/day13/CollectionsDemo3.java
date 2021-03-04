package day13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsDemo3 {
	public static void main(String[] args) {
		// Set only accepts unique values
		// Indexed search is possible using Set
		// The order may not be the same in Set
		Set<String> mySet = new HashSet<String>();
		mySet.add("Hello (Set)");
		mySet.add("World (Set)");
		mySet.add("Hello (Set)");
		mySet.add("Foo (Set)");
		mySet.add("Bar (Set)");
		System.out.println(mySet);
		
		// TreeSet will have a fixed order
		// Ascending order TreeSet
		Set<String> myTreeSet = new TreeSet<String>();
		// Descending order TreeSet uses a comparator
//		Set<String> myDescendingTreeSet = new TreeSet<String>((ts1, ts2) -> { return ts2.compareTo(ts1); });
		myTreeSet.add("Hello (TreeSet)");
		myTreeSet.add("World (TreeSet)");
		myTreeSet.add("Hello (TreeSet)");
		myTreeSet.add("Foo (TreeSet)");
		myTreeSet.add("Bar (TreeSet)");
		System.out.println(myTreeSet);
		
		// for-each loop
		for(String s : mySet) {
			System.out.println(s);
		}
		
		// Iterator
		Iterator<String> iter = myTreeSet.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
