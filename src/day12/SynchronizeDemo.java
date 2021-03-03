package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Two threads, one object, two jobs
public class SynchronizeDemo {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		ReservationCounter central = new ReservationCounter();
		// Thread 1
		es.execute(() -> {
			Thread.currentThread().setName("Ramu");
			// Object lock - synchronize central object
			synchronized(central) {
				central.bookTicket(1000);
				central.giveChange();
			}
		});
		// Thread 2
		es.execute(() -> {
			Thread.currentThread().setName("Somu");
			// Object lock - synchronize central object
			synchronized(central) {
				central.bookTicket(500);
				central.giveChange();
			}
//			central.drinkWater();
		});
		// No other thread can be accepted
		es.shutdown();
	}
}

/*
 * Class/method lock (optimistic lock) - synchronized keyword
 * When a method is synchronized, only ONE thread can be inside the method
 * Even if the thread undergoes an interruption, another thread cannot enter
 * Until the tread comes out of the method, another thread cannot enter a synchronized method
 * Another thread cannot enter the other synchronized method also 
 * This is because the monitor created is for all the synchronized methods.
 * When Ramu is inside bookTicket, Somu cannot enter giveChange method
 */

/*
 * Object lock (pessimistic lock)
 * The methods are not in monitor, the object itself is in monitor
 */

class ReservationCounter {
	int amount;
	synchronized public void bookTicket(int amount) {
		this.amount = amount;
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println(name + " paid " + amount + " to book tickets.");
		try {
			Thread.sleep(1000); 
		}
		catch (Exception e) {}
	}
	synchronized public void giveChange() {
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println((amount - 100) + " change is given to " + name);
	}
	synchronized public void drinkWater() {
		System.out.println(Thread.currentThread().getName() + " is drinking water.");
	}
}