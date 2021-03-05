package day13LabBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Program22 {
	public static void main(String[] args) {
		String[] array = {"Hello", "Hi", "hello", "HI"};
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		
		System.out.println(Arrays.binarySearch(array, "Hello"));
		System.out.println(Arrays.binarySearch(array, "HELLO"));
		
		List<Integer> lst = new ArrayList<Integer>();
		lst.add(22);
		lst.add(11);
		lst.add(44);
		lst.add(33);
		Collections.sort(lst);
		System.out.println(lst);
		
		System.out.println(Collections.binarySearch(lst, 22));
		System.out.println(Collections.binarySearch(lst, 35));
	}
}
