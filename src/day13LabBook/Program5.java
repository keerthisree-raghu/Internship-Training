package day13LabBook;

import java.util.ArrayList;

public class Program5 {
	public static void main(String[] args) {
		ArrayList<String> n = new ArrayList<>();
		n.add("one");
		n.add("two");
		System.out.println(n.contains(new String("one")));
		System.out.println(n.indexOf("two"));
		n.clear();
		System.out.println(n);
		System.out.println(n.get(1));
	}
}
