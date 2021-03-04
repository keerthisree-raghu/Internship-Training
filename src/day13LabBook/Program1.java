package day13LabBook;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Program1 {
	public static class PhoneBookComparator implements Comparator<PhoneBookEntry> {
		public int compare(PhoneBookEntry o1, PhoneBookEntry o2) {
			return o2.name.compareToIgnoreCase(o1.name);
		};
	}
	public static void main(String[] args) {
		PhoneBookEntry addr1 = new PhoneBookEntry("Peter");
		PhoneBookEntry addr2 = new PhoneBookEntry("Paul");
		PhoneBookEntry addr3 = new PhoneBookEntry("Patrick");
		Comparator<PhoneBookEntry> comp = new PhoneBookComparator();
		TreeSet<PhoneBookEntry> set = new TreeSet<>(comp);
		set.add(addr1);
		set.add(addr2);
		set.add(addr3);
		System.out.println(set);
		Set<PhoneBookEntry> newSet = set.descendingSet();
		System.out.println(newSet);
	}
}

class PhoneBookEntry {
	public String address, phone;
	final String name;
	public PhoneBookEntry(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}
}
