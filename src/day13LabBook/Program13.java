package day13LabBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program13 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		fillData(map);
		String[] strings = keysAsArray(map);
		for(String string : strings) {
			System.out.println(string);
		}
		List<String> list = keysAsList(map);
		for(String string : list) {
			System.out.println(string);
		}
	}
	private static void fillData(Map<String, String> map) {
		map.put("Android", "Mobile");
		map.put("Eclipse IDE", "Java");
		map.put("Eclipse RCP", "Java");
		map.put("Git", "Version Control");
	}
	private static String[] keysAsArray(Map<String, String> map) {
		return map.keySet().toArray(new String[map.keySet().size()]);
	}
	private static List<String> keysAsList(Map<String, String> map) {
		List<String> list = new ArrayList<String>(map.keySet());
		return list;
	}
}
