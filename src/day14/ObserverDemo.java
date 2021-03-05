package day14;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObserverDemo {
	public static void main(String[] args) {
		FireAlarm shakthi = new FireAlarm();
		Student ey = new Student();
		Teacher shoiab = new Teacher();
		shakthi.addObserver(ey);
		shakthi.addObserver(shoiab);
		shakthi.setAlarm();
	}
}

class MultiThreadedObservable extends Observable {
	Vector<Observer> vector = new Vector<>();
	@Override
	public synchronized void addObserver(Observer o) {
		vector.add(o);
	}

	@Override
	public void notifyObservers(Object arg) {
		ExecutorService es = Executors.newFixedThreadPool(vector.size());
		Enumeration<Observer> en = vector.elements();
		while(en.hasMoreElements()) {
			Observer obs = en.nextElement();
			es.execute(()->{obs.update(this, arg);});
		}
		es.shutdown();
	}

}

class FireAlarm extends MultiThreadedObservable {
	public void setAlarm() {
		setChanged();
		notifyObservers("Fire in the mountain run run run...");
	}
}

class Student implements Observer {
	@Override
	public void update(Observable o, Object arg) {
		timeToRun((String) arg);
	}

	public void timeToRun(String msg) {
		System.out.println("The student is running... " + msg);
	}
}

class Teacher implements Observer {
	@Override
	public void update(Observable o, Object arg) {
		timeToRun((String) arg);
	}

	public void timeToRun(String msg) {
		System.out.println("Should we run?");
		System.out.println("The teacher is thinking...");
		try {
			Thread.sleep(10000);
		} 
		catch (Exception e) {}
		System.out.println("The teacher is running... " + msg);
	}
}