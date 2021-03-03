package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DaemonThreadDemo {
	public DaemonThreadDemo() {
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				while(true) {
//					System.out.println("Child thread.");
//				}
//			}
//		}).start();
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.execute(() -> {
			while(true) {
				System.out.println("Child thread.");
			}
		});
	}
	public static void main(String[] args) {
		new DaemonThreadDemo();
		System.out.println("Main thread.");
		// Even after main thread dies, child thread continues to run
		Thread.currentThread().setDaemon(true);
		try {
			Thread.sleep(10000);
		}
		catch(Exception e) { }
		System.exit(1);
	}
}
