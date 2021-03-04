package day13;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class CollectionsDemo2 {
	public static void main(String[] args) {
		Vector<String> v = new Vector<>();
		// All the methods in Vector are synchronized
		v.add("Hello");
		v.add("World");
		v.add("Foo");
		v.add("Bar");
		
		System.out.println(v);
		
		Enumeration<String> e = v.elements();
		Iterator<String> i = v.iterator();
		
		// Cannot add any more elements after initializing an iterator
		// Will throw an error in the case of iterator, but not in the cae of enumeration
		v.add("Baz");
		
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
