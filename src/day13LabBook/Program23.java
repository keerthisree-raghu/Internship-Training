package day13LabBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program23 {
	public static void main(String[] args) {
		List<String> lst = new ArrayList<String>();
		lst.add("alpha");
		lst.add("beta");
		lst.add("charlie");
		Object[] strArray1 = lst.toArray();
		System.out.println(Arrays.toString(strArray1));
		String[] strArray2 = lst.toArray(new String[0]);
		strArray2[1] = "delta";
		System.out.println(Arrays.toString(strArray2));
		System.out.println(lst);
	}
}
