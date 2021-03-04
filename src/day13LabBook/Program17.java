package day13LabBook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Program17 {
	public static void main(String[] args) {
		Collection intList = new ArrayList();
		int[] values = {9, 11, -4, 1, 13, 99, 1, 0};
		for(int i = 0; i < values.length; i++) {
			intList.add(new Integer(values[i]));
		}
		System.out.println("Before: " + intList);
		Iterator iterator = intList.iterator();
		while(iterator.hasNext()) {
			Integer element = (Integer)iterator.next();
			int value = element.intValue();
			if(value < 1 || value > 10) {
				iterator.remove();
			}
		}
		System.out.println("After: " + intList);
	}
}
