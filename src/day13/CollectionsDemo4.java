package day13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CollectionsDemo4 {
	public static void main(String[] args) {
		// Map collection has a key-value pair
		// The key-value pairs in Map are not sorted by default
		Map<MyKey, String> map = new HashMap<>();
		
		MyKey key1 = new MyKey("Hello");
		MyKey key2 = new MyKey("Foo");
		MyKey key3 = new MyKey("Baz");
		
		map.put(key1, "World");
		map.put(key2, "Bar");
		map.put(key3, "Bat");
		
		System.out.println(map);
		
		// Key-value pairs in tree map are sorted by default
		// Tree map always requires a comparator
		Map<MyKey, String> treeMap = new TreeMap<>((o1, o2) -> {return o2.compareTo(o1);});
		
		MyKey myKey1 = new MyKey("John");
		MyKey myKey2 = new MyKey("Jane");
		MyKey myKey3 = new MyKey("Jim");
		
		treeMap.put(myKey1, "Doe");
		treeMap.put(myKey2, "Roe");
		treeMap.put(myKey3, "Smith");
		
		System.out.println(treeMap);
		
		String result = treeMap.get(myKey1);
		System.out.println("Value of " + myKey1 + " is " + result);
		
		Set<Map.Entry<MyKey, String>> set = treeMap.entrySet();
		
		Iterator<Map.Entry<MyKey, String>> iter = set.iterator();
		
		while(iter.hasNext()) {
			Map.Entry<MyKey, String> entry = iter.next();
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}

// They key is user-defined
class MyKey implements Comparable<MyKey> {
	String key;
	public MyKey(String key) {
		this.key = key;
	}
	@Override
	public String toString() {
		return this.key;
	}
	@Override
	public int compareTo(MyKey o) {
		return this.key.compareTo(o.key);
	}
}
