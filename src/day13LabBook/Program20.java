package day13LabBook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

public class Program20 {
	public static void main(String[] args) {
		HashSet set1 = new HashSet();
		addRange(set1, 1);
		ArrayList list1 = new ArrayList();
		addRange(list1, 2);
		TreeSet set2 = new TreeSet();
		addRange(set2, 3);
		set1.removeAll(list1);
		list1.addAll(set2);
		System.out.println(set1);
	}
	static void addRange(Collection col, int step) {
		for(int i = step * 3; i <= 12; i += step) {
			col.add(new Integer(i));
		}
	}
}
