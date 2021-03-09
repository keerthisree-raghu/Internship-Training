package day16;

import java.util.StringJoiner;
import java.util.StringTokenizer;

public class StringDemo {
	public static void main(String[] args) {
		String s = "Hello World"; // Heap representation
		String ss = new String("Hello World"); // Stack representation
		
		// Strings are immutable
		String temp = ss;
		ss = "World World " + ss;
		System.out.println("Changed string: " + temp);
		System.out.println("Original string: " + ss);
		
		// Non-synchronized
		StringBuilder sb = new StringBuilder("Hello world from string builder. ");
		System.out.println("Original string builder string: " + sb);
		sb.append("New value appended to string builder.");
		System.out.println("Appended string builder string: " + sb);
		
		// Synchronized
		StringBuffer sbf = new StringBuffer("Hello world from string buffer. ");
		System.out.println("Original string buffer string: " + sbf);
		sb.append("New value appended to string buffer.");
		System.out.println("Appended string buffer string: " + sbf);
		
		// Join strings - argument value in between each string
		StringJoiner sJoiner = new StringJoiner(", ");
		System.out.println(sJoiner);
		sJoiner.add("Hello");
		sJoiner.add("World");
		System.out.println(sJoiner);
		
		sJoiner = new StringJoiner(", ", "[", "]");
		sJoiner.add("Hello");
		sJoiner.add("World");
		sJoiner.add("Hi");
		sJoiner.add("Earth");
		System.out.println(sJoiner);
		
		StringTokenizer sToken = new StringTokenizer(sJoiner.toString(), ", ");
		while(sToken.hasMoreTokens()) {
			System.out.println(sToken.nextToken());
		}
	}
}
