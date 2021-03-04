package day13;

import java.util.ArrayList;

public class GenericsDemo2 {
	public static void main(String[] args) {
		int arr[] = new int[5];
		
		ArrayList<String> arrList = new ArrayList<>();
		arrList.add("abcde");
		// Throws error since it is not of the same type
//		arrList.add(123);
//		arrList.add(3.14f);
		
		for(int i = 0; i < arrList.size(); i++) {
			String s = (String)arrList.get(i);
		}
	}
}
