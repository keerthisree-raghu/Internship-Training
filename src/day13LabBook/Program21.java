package day13LabBook;

import java.util.Arrays;
import java.util.List;

public class Program21 {
	public static void main(String[] args) {
		String[] strs = {"alpha", "beta", "charlie"};
		System.out.println(Arrays.toString(strs));
		List<String> lst = Arrays.asList(strs);
		strs[0] += "88";
		lst.set(2, lst.get(2) + "99");
		System.out.println(Arrays.toString(strs));
		System.out.println(lst);
		List<Integer> lstInt = Arrays.asList(22, 44, 11, 33);
		System.out.println(lstInt);
	}
}
