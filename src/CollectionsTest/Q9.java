package CollectionsTest;

import java.util.*;

/*
 * OPTION A. Fragment I compiles
 * OPTION C. Fragment III compiles
 * OPTION D. Fragment I executes without exception
 * OPTION F. Fragment III executes without exception 
 */

public class Q9 {
	public static void main(String[] args) {
		Object o = new Object();
//		Set s = new HashSet();
//		TreeSet s = new TreeSet();
		LinkedHashSet s = new LinkedHashSet();
		s.add("o");
		s.add(o);
	}
}
