package day10;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

/*
 * An interface is a special class whose activity is promised by the class which
 * implements it and when a behavioral object is subjected to the implementation,
 * the behavioral object becomes a component.
 * 
 * Doctor is a special class whose activity is implemented in medical college.
 * When shoiab is subjected to medical college, shoiab becomes a part of (COMPONENT)
 * of the medical fraternity as a doctor. People REALIZE the objective of getting
 * cured by going to shoiab who in turn plays the ROLE of a doctor.
 */

public class InterfaceDemo {
	public static void main(String[] args) {
		Object shoiab = new Human();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please make me a doctor.");
		System.out.println("Press any key to continue.");
		scan.next();
		
		StanleyAlopathyMC stanley = new StanleyAlopathyMC();
		JetAcademy jet = new JetAcademy();
		// Subjection - happens at runtime
		shoiab = Proxy.newProxyInstance(Human.class.getClassLoader(), new Class[] {Doctor.class}, new MyInvocationHandler(stanley));
		
		Doctor doctorShoiab = (Doctor)shoiab; // Happens at runtime
		doctorShoiab.doCure();

//		Pilot pilotShoiab = (Pilot)shoiab;
//		pilotShoiab.doFly();
	}
}

// Behavioral class
class Human {
	
}

class MyInvocationHandler implements InvocationHandler {
	Object obj;
	public MyInvocationHandler(Object obj) {
		this.obj = obj;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Invoke method called...");
		Object ob = method.invoke(obj, args);
		return ob;
	}
}

interface Doctor {
	public void doCure();
}

class StanleyAlopathyMC implements Doctor {
	@Override
	public void doCure() {
		System.out.println("Cure using Alopathy.");
	}
}

interface Pilot {
	public void doFly();
}

class JetAcademy implements Pilot {
	@Override
	public void doFly() {
		System.out.println("Fly an airplane.");
	}
}