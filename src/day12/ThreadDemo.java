package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {
	public ThreadDemo() {
//		Thread t = new Thread(new ThreadJob());
//		t.start();
		// Executor framework - from JDK 5
		ExecutorService es = Executors.newFixedThreadPool(1);
//		es.execute(new ThreadJob());
		es.execute(() -> {System.out.println("Child thread is running using lambda.");});
		es.shutdown();
	}
	public static void main(String[] args) throws Exception {
		// Thread creation using constructor
		new ThreadDemo();
		// Thread creation using Thread class
		Thread t = Thread.currentThread();
		// Give a name to the thread
		t.setName("javathread");
//		System.out.println(t); // Thread[name, priority, group]
//		System.exit(1); // Kills the thread
		for(int i = 0; i < 5; i++) {
			// Each value of i is printed after 1000 ms
			System.out.println(i);
			// Makes the thread halt for 1000 ms
			Thread.sleep(1000);
		}
	}
}

// Create a thread job using Runnable interface
class ThreadJob implements Runnable {
	@Override
	public void run() {
		System.out.println("Child thread is running.");
	}
}
