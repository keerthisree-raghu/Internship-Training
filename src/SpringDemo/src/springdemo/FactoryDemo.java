package springdemo;

import java.util.List;

public class FactoryDemo {
	public static void main(String[] args) {

	}
}

abstract class Shoe {

}

class LeatherShoe extends Shoe {
	@Override
	public String toString() {
		return "Leather shoe by Bata.";
	}
}

class SportsShoe extends Shoe {
	@Override
	public String toString() {
		return "Sports shoe by Lakhani.";
	}
}

interface Manufacturer {

}

interface ShoeManufacturer extends Manufacturer {
	public Shoe makeShoe();
}

abstract class ShoeFactory implements ShoeManufacturer {

}

class BataShoeFactory extends ShoeFactory {
	public BataShoeFactory() {
		System.out.println("Bata Shoe Factory object created.");
	}

	@Override
	public Shoe makeShoe() {
		return new LeatherShoe();
	}
}

class LakhaniShoeFactory extends ShoeFactory {
	public LakhaniShoeFactory() {
		System.out.println("Lakhani Shoe Factory object created.");
	}

	@Override
	public Shoe makeShoe() {
		return new SportsShoe();
	}
}

abstract class Customer {
	private String name;

	public Customer(String name) {
		this.setName(name);
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}
}

class ShoeCustomer extends Customer {
	public ShoeCustomer(String name) {
		super(name);
	}
}

interface Seller {

}

interface ShoeSeller extends Seller {
	public Shoe sellShoe(Customer customer);
}

abstract class ShoeShop implements ShoeSeller {
	private ShoeFactory factory;

	public final ShoeFactory getFactory() {
		return factory;
	}

	public final void setFactory(ShoeFactory factory) {
		System.out.println("Set factory called: " + factory);
		this.factory = factory;
	}
}

class GokulShoeShop extends ShoeShop {
	private List<String> myList;

	public GokulShoeShop(ShoeFactory factory) {
		System.out.println("Gokul Shoe Shop constructor injection.");
		setFactory(factory);
	}

	public GokulShoeShop() {
		System.out.println("Gokul Shoe Shop created.");
	}

	private String name;

	public GokulShoeShop getClone() {
		try {
			return (GokulShoeShop) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Shoe sellShoe(Customer customer) {
		System.out.println("Shoe bought by: " + customer.getName());
		return getFactory().makeShoe();
	}

	public void setUp() {
		System.out.println("Set up called.");
	}

	public void destruct() {
		System.out.println("Destroy method called.");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMylist() {
		return myList;
	}

	public void setMylist(List<String> mylist) {
		this.myList = mylist;
	}
}
