package CollectionsTest;

import java.util.ArrayList;
import java.util.List;

public class Q1 {
	public static void main(String[] args) {
//		List<List<Integer>> table = new List<List<Integer>>(); // Cannot instantiate
		List<List<Integer>> table = new ArrayList<List<Integer>>(); // OPTION B
//		List<List<Integer>> table = new ArrayList<ArrayList<Integer>>(); // Cannot convert type
//		List<List, Integer> table = new List<List, Integer>(); // References to generic type List should be parameterized
//		List<List, Integer> table = new ArrayList<List, Integer>(); // References to generic type List should be parameterized
//		List<List, Integer> table = new ArrayList<ArrayList, Integer>(); // References to generic type List should be parameterized
		for(int i = 0; i <= 10; i++) {
			List<Integer> row = new ArrayList<Integer>();
			for(int j = 0; j <= 10; j++) {
				row.add(i * j);
			}
			table.add(row);
		}
		for(List<Integer> row : table) {
			System.out.println(row);
		}
	}
}
