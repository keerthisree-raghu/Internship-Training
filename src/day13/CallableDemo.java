package day13;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
	public static void main(String[] args) throws Exception {
		ExecutorService es = Executors.newFixedThreadPool(1);
		Future<Integer> future = es.submit(new MyCallable());
		Integer i = future.get();
		System.out.println(i);
		es.shutdown();
	}
}

class MyCallable implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (Exception e) { }
		return 1000;
	}
}