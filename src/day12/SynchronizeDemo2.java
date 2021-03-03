package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Producer-consumer example

// Two threads, one object, one job
public class SynchronizeDemo2 {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		Gun bofors = new Gun();
		es.execute(() -> {
			for(int i = 0; i < 5; i++) {
				bofors.loadGun();
			}
		});
		es.execute(() -> {
			for(int i = 0; i < 5; i++) {
				bofors.shootGun();
			}
		});
		es.shutdown();
	}
}

class Gun {
	boolean isLoaded;
	// Loading and shooting cannot happen simultaneously
	synchronized public void loadGun() {
		if(isLoaded) {
			try { wait(); }
			catch(Exception e) {}
		}
		System.out.println("I will load the gun.");
		// Gun is loaded
		isLoaded = true;
		notify();
	}
	
	synchronized public void shootGun() {
		if(!isLoaded) {
			try { wait(); }
			catch(Exception e) {}
		}
		System.out.println("I will shoot the gun.");
		// Gun is empty
		isLoaded = false;
		notify();
	}
}

/*
 * When a thread is in sleep mode, another thread cannot enter the monitor
 * When a thread is in wait mode, another thread can enter the monitor
 * Time parameter is mandatory in sleep mode
 * Time parameter is optional in wait mode
 */