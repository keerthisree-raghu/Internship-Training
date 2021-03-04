package day13;

import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

public class CollectionsDemo6 {
	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
		
		// Key-value pairs can be loaded from an external file
		prop.load(new FileInputStream("test.properties"));
		
		Enumeration e = prop.elements();
		
		while(e.hasMoreElements()) {
			String value1 = (String)e.nextElement();
			String value2 = prop.getProperty("Foo");
			String value3 = prop.getProperty("Baz");
			
			System.out.println(value1 + ":" + value2 + ":" + value3);
		}
	}
}
