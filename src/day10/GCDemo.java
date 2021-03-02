package day10;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class GCDemo {
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		System.out.println("Before thatha's birth: " + r.freeMemory());
		GrandFather thatha = new GrandFather();
		System.out.println("After thatha's birth: " + r.freeMemory());
		System.out.println("Thatha lives for some time and then dies...");
		// WeakReference weakthatha=new WeakReference(thatha);
		SoftReference softThatha = new SoftReference(thatha);
		// PhantomReference phantomthatha=new PhantomReference(thatha);
		thatha = null;
		// System.out.println(thatha.getGold());
		System.out.println("After thathas death: " + r.freeMemory());
		System.out.println("Thatha's kariyam starts... ");
		System.out.println(thatha);
		System.gc();
		System.out.println("After thathas kariyam... " + r.freeMemory());
		thatha = (GrandFather) softThatha.get();
		System.out.println(thatha);
	}
}

class GrandFather {
	private String gold = "under the tree";
	String space;

	public GrandFather() {
		for (int i = 0; i < 10000; i++) {
			space = new String(" " + i);
		}
	}

	protected String getGold() {
		return gold;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Gold is: " + gold);
	}
}