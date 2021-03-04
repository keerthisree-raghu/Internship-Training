package day13;

import java.util.Map;
import java.util.WeakHashMap;

public class CollectionsDemo5 {
	public static void main(String[] args) {
		// Weak Hash Map is used to ensure that the objects are weak
		Map<MyKey, String> map = new WeakHashMap<MyKey, String>();
		
		MyKey key1 = new MyKey("Hello");
		MyKey key2 = new MyKey("Foo");
		MyKey key3 = new MyKey("Baz");
		
		map.put(key1, "World");
		map.put(key2, "Bar");
		map.put(key3, "Bat");
		
		System.out.println(map);
		
		// Weak objects are removed after garbage collection
		key1 = null;
		System.out.println("Before garbage collection:");
		System.out.println(map);
		System.gc();
		System.out.println("After garbage collection:");
		System.out.println(map);
	}
}
