package day11;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class ExceptionDemo {
	public static void main(String[] args) throws Exception {
		Dog dog;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter Item 1: ");
		String item1 = scan.next();
		dog = Child.getItem(item1);
		Child child = new Child();
		child.playWithDog(dog);
		
		System.out.println("Enter Item 2: ");
		String item2 = scan.next();
		dog = Child.getItem(item2);
		Child child2 = new Child();
		child2.playWithDog(dog);
	}
}

// Method invocation handler to create object proxies upon invocation

class MethodInvocationHandler implements InvocationHandler {
	Object obj;
	// Dynamic proxy creation
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		obj = method.invoke(obj, args);
		return obj;
	}
	public MethodInvocationHandler(Object obj) {
		this.obj = obj;
	}
}

// Custom exception classes

abstract class DogExceptions extends Exception {
	// Create instance of a proxy class for 911 handler interfaces
	Object obj = Proxy.newProxyInstance(Handler911.class.getClassLoader(), new Class[] {Handler911.class}, new MethodInvocationHandler(new Handler911India()));
	public abstract void visit();
	String message;
	@Override
	public String toString() {
		return message;
	}
}

class DogBiteException extends DogExceptions {
	static DogBiteException dogbite;
	String msg;
	public DogBiteException(String msg) {
		this.msg = msg;
	}
	@Override
	public void visit() {
		((Handler911)obj).handle(this);
	}
	public static DogBiteException handleDogBiteException() {
		dogbite = new DogBiteException("You beat, I bite.");
		return dogbite;
	}
}

class DogBarkException extends DogExceptions {
	static DogBarkException dogbark;
	String msg;
	public DogBarkException(String msg) {
		this.msg = msg;
	}
	@Override
	public void visit() {
		((Handler911)obj).handle(this);
	}
	public static DogBarkException handleDogBarkException() {
		dogbark = new DogBarkException("You throw, I bark.");
		return dogbark;
	}
}

class DogHappyException extends DogExceptions {
	static DogHappyException doghappy;
	String msg;
	public DogHappyException(String msg) {
		this.msg = msg;
	}
	@Override
	public void visit() {
		((Handler911)obj).handle(this);
	}
	public static DogHappyException handleDogHappyException() {
		doghappy = new DogHappyException("You give, I eat.");
		return doghappy;
	}
}

// Play items classes - to be dynamically provided at runtime

abstract class Item {
	public Item() {	}
	public abstract void execute() throws DogExceptions;
}

class StickItem extends Item {
	public StickItem() {
		System.out.println("The dog was hit with a stick.");
	}
	@Override
	public void execute() throws DogExceptions {
		throw DogBiteException.handleDogBiteException();
	}
}

class StoneItem extends Item {
	public StoneItem() {
		System.out.println("A stone was thrown at the dog.");
	}
	@Override
	public void execute() throws DogExceptions {
		throw DogBarkException.handleDogBarkException();
	}
}

class BiscuitItem extends Item {
	public BiscuitItem() {
		System.out.println("A biscuit was given to the dog.");
	}
	@Override
	public void execute() throws DogExceptions {
		throw DogHappyException.handleDogHappyException();
	}
}

// Create clones for Dog and Child objects to save processing time

class Dog implements Cloneable {
	Dog dog;
	Item item;
	public void play(Item item) throws DogExceptions {
		item.execute();
	}
	Dog getDogClone() throws Exception {
		return (Dog)super.clone();
	}
}

class Child implements Cloneable {
	public Child() {
//		System.out.println("Child is playing with the dog.");
	}
	public static Dog getItem(String playItem) throws Exception {
		Item item = (Item)Class.forName(playItem).getConstructor().newInstance();
		Dog dog = new Dog();
		dog.item = item;
		return dog;
	}
	public void playWithDog(Dog dog) {
		// The play method does not get executed - exception is thrown here
		try {
			dog.play(dog.item);
		}
//		catch(DogBiteException dogbite) {
//			new Handler911India().handle(dogbite);
//		}
//		catch(DogBarkException dogbark) {
//			new Handler911India().handle(dogbark);
//		}
//		catch(DogHappyException doghappy) {
//			new Handler911India().handle(doghappy);
//		}
		// Handles all dog exception
		catch(DogExceptions de) {
			de.visit();
		}
	}
	public Child getChildClone() throws Exception {
		return (Child)super.clone();
	}
}

// 911 handler interfaces

interface Handler911 {
	public abstract void handle(DogBiteException dogbite);
	public abstract void handle(DogBarkException dogbark);
	public abstract void handle(DogHappyException doghappy);
}

class Handler911India implements Handler911 {
	@Override
	public void handle(DogBarkException dogbark) {
		System.out.println("Do not panic, it will not bite. Barking dogs seldom bite.");
		
	}
	@Override
	public void handle(DogBiteException dogbite) {
		System.out.println("Please take the dog to a hospital or we will send an ambulance.");
	}
	@Override
	public void handle(DogHappyException doghappy) {
		System.out.println("The dog is happy. You can play with the dog.");
	}
}