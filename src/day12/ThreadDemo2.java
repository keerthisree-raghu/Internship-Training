package day12;

public class ThreadDemo2 {
	public static void main(String[] args) {
		System.out.println("Line 1...");
		// Main thread will not wait for child thread
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				method();
//			}
//		}).start();
		// Lambda
		new Thread(() -> {method();});
		System.out.println("Line 3...");
	}
	
	public static void method() {
		System.out.println("Line 2...");
		try {
			Thread.sleep(5000);
		}
		catch(Exception e) {}
	}
}
