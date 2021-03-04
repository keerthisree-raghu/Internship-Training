package day13LabBook;

import java.util.Enumeration;
import java.util.Hashtable;

public class Program11 {
	public static void main(String[] args) {
		Hashtable<String, Double> balance = new Hashtable<String, Double>();
		Enumeration<String> names;
		String str;
		double bal;
		balance.put("Deepak Patel", 3243.53);
		balance.put("Devraj Singh", 322.43);
		balance.put("Rajat Patel", 4323.00);
		balance.put("Vikrant Patel", 43.54);
		balance.put("Ravi Patel", -43.04);
		names = balance.keys();
		while(names.hasMoreElements()) {
			str = names.nextElement();
			System.out.println(str + ": " + balance.get(str));
		}
		System.out.println();
		bal = balance.get("Deepak Patel");
		balance.put("Deepak Patel", bal + 1000);
		System.out.println("Deepak Patel's new balance: " + balance.get("Deepak Patel"));
	}
}
