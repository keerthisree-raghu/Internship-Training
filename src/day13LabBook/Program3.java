package day13LabBook;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Program3 {
	public static void main(String[] args) {
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		hmap.put(11, "AB");
		hmap.put(2, "CD");
		hmap.put(33, "EF");
		hmap.put(9, "GH");
		hmap.put(3, "IJ");
		
		Iterator iterator = hmap.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry me2 = (Map.Entry) iterator.next();
			System.out.println("Key: " + me2.getKey() + " & Value: " + me2.getValue());
		}
	}
}
