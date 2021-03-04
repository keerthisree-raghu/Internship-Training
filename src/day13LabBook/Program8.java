package day13LabBook;

import java.util.ArrayList;
import java.util.ListIterator;

public class Program8 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("s");
		list.add("o");
		list.add("l");
		list.add("v");
		list.add("e");
		list.add("r");
		ListIterator iterator = list.listIterator();
		System.out.println("Displaying list elments:");
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
		System.out.println("Displaying list elements in reverse:");
		while(iterator.hasPrevious()) {
			System.out.print(iterator.previous() + " ");
		}
		System.out.println();
	}
}
