package day1;

// Question 14

// 14.b Execute java program by giving different name to class and file.
// public class JavaDocDemo { -> will show an error (file name and class name are different)
public class JavaDoc {
	// 14.a Write a program with comment documentation, execute javadoc on the file, and view through the web browser.
	/**
	 * This is an example of a documentation comment.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("JavaDoc");
	}
	// 14.c.i Without public modifier - Main method not found in class error
//	static void main(String[] args) {
//		System.out.println("Without public modifier");
//	}
	// 14.c.ii Without static keyword - Main method is not in static class error
//	public void main(String[] args) {
//		System.out.println("Without static keyword");
//	}
	// 14.c.iii Without function parameter - Main method not found in class error
//	public static void main() {
//		System.out.println("Without function parameter");
//	}
}
