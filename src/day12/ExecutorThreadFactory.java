package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExecutorThreadFactory {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(1, new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				// Capturing thread
				Thread t = Executors.defaultThreadFactory().newThread(r);
				return t;
			}
		});
		es.execute(() -> {
			System.out.println("Thread called.");
		});
	}
}
