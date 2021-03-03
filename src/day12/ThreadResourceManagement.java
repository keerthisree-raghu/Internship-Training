package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Many threads, one object, one resource object to one thread
public class ThreadResourceManagement {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(() -> {
			Laptop laptop = EYOffice.getLaptopFromLocker("Ramu");
			EYOffice.getLaptopFromLocker("Ramu");
			EYOffice.getLaptopFromLocker("Ramu");
			EYOffice.getLaptopFromLocker("Ramu");
			EYOffice.getLaptopFromLocker("Ramu");
			EYOffice.closeMyLaptop();
			EYOffice.getLaptopFromLocker("Ramu");
		});
		es.execute(() -> {
			Laptop laptop3 = EYOffice.getLaptopFromLocker("Somu");
			EYOffice.getLaptopFromLocker("Somu");
			EYOffice.getLaptopFromLocker("Somu");
			EYOffice.getLaptopFromLocker("Somu");
			EYOffice.getLaptopFromLocker("Somu");
		});
		es.shutdown();
	}
}

class EYOffice {
	private static ThreadLocal locker = new ThreadLocal();
	public static Laptop getLaptopFromLocker(String name) {
		Laptop laptop = (Laptop)locker.get();
		if(laptop == null) {
			laptop = new Laptop(name);
			locker.set(laptop);
		}
		return laptop;
	}
	public static void closeMyLaptop() {
		Laptop laptop = (Laptop)locker.get();
		if(laptop != null) {
			System.out.println("Laptop removed.");
			locker.remove();
		}
	}
}

class Laptop {
	String name;
	public Laptop(String name) {
		System.out.println(name + " laptop created.");
		this.name = name;
	}
	@Override
	public String toString() {
		return "Laptop belongs to " + name;
	}
}
