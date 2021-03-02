package day11;

public class Q3 {
	public void math1() {
		math2();
		System.out.println("caller");
	}
	public void math2() {
		try {
			int a = 10 / 0;
			System.exit(0);
		}
		catch(Exception e) {
			System.out.println("catch math2");
		}
		finally {
			System.out.println("finally math2");
		}
	}
	public static void main(String[] args) {
		Q2 q2 = new Q2();
		q2.math1();
	}
}
