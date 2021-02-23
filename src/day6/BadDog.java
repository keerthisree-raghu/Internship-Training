package day6;

import java.util.Scanner;

public class BadDog {
	public static void main(String[] args) throws Exception {
		Dog dog = Child.getItem(args[0]);
		dog.playWithItem();
	}
}

class Dog {
	Item item;
	public void playWithItem() {
		item.play();
	}
}


class Child {
	public static Dog getItem(String itemName) throws Exception {
		Dog dog = new Dog();
		Item item = (Item)Class.forName(itemName).newInstance();
		dog.item = item;
		return dog;
	}
}

abstract class Item {
	public abstract void play();
}

class Stick extends Item {
	@Override
	public void play() {
		System.out.println("The dog will bite.");
	}
}

class Stone extends Item {
	@Override
	public void play() {
		System.out.println("The dog will bark.");
	}
}

//if-else-if chain to be eliminated

//class Dog {
//	public void play(String item) {
//		if(item.equals("stick")) {
//			System.out.println("The dog will bite.");
//		}
//		else if(item.equals("stone")) {
//			System.out.println("The dog will bark.");
//		}
//	}
//}
