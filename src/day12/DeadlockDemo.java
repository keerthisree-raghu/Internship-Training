package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadlockDemo {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		Crane crane = new Crane();
		Frog frog = new Frog();
		es.execute(() -> {
			crane.eat(frog);
		});
		es.execute(() -> {
			frog.escape(crane);
		});
		es.shutdown();
	}
}

// Two objects, two threads, two jobs
class Crane {
	synchronized public void eat(Frog frog) {
//		try {
//			Thread.sleep(5000);
//		}
//		catch(Exception e) {}
		frog.leaveCrane();
		System.out.println("Frog has been eaten.");
	}
	synchronized public void spitFrog() {
		
	}
}

class Frog {
	synchronized public void escape(Crane crane) {
		crane.spitFrog();
	}
	synchronized public void leaveCrane() {
		
	}
}