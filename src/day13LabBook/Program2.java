package day13LabBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program2 {
	public static void main(String[] args) {
		System.out.println("output");
		List<String> l1 = createList();
		l1.removeIf(s->s.toLowerCase().contains("and"));
		l1.forEach(s->System.out.println(s));
	}
	private static List<String> createList() {
		List<String> anotherList = new ArrayList<>();
		anotherList.addAll(Arrays.asList("lion", "king", "queen", "cat and rat", "mat"));
		return anotherList;
	}
}
