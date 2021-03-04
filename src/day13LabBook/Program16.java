package day13LabBook;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Program16 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		Random random = new Random();
		for(int i = 3; i <= 5; i++) {
			list.add(new Integer(random.nextInt()));
		}
		System.out.println(list);
		Iterator iter = list.iterator();
		while(iter.equals(list)) {
			int i = ((Integer)iter.next()).intValue();
			System.out.println(i);
		}
	}
}
