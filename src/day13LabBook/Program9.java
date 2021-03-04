package day13LabBook;

import java.util.HashSet;
import java.util.Set;

public class Program9 {
	private int id;
	private String value;
	public Program9(int id, String value) {
		this.id = id;
		this.value = value;
	}
	public int getId() {
		return this.id;
	}
	public String getValue() {
		return this.value;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}
	public static void main(String[] args) {
		Set<Program9> set = new HashSet<Program9>();
		Program9 p = new Program9(1, "one");
		Program9 p2 = new Program9(2, "two");
		set.add(p);
		set.add(p2);
		System.out.println("Size of the set is " + set.size());
	}
}

