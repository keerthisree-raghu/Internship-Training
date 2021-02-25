package day8;

import java.util.Scanner;

public class FactoryPattern {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		System.out.print("Shop Class Name: ");
		String shopclass = scan.next();
		System.out.print("Factory Class Name: ");
		String factoryclass = scan.next();
		
		ShoeShop shoeshop = ShoeContainer.getShoeShop(shopclass, factoryclass);
		Shoe shoe = shoeshop.sellShoe(new ShoeCustomer("Ramu"));
		
		System.out.println("Shoe: " + shoe);
	}
}

class ShoeContainer {
	public static ShoeShop getShoeShop(String shopclass, String factoryclass) throws Exception {
		ShoeFactory factory = (ShoeFactory)Class.forName(factoryclass).newInstance();
		ShoeShop shop = (ShoeShop)Class.forName(shopclass).newInstance();
		shop.setShoeFactory(factory);
		return shop;
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
	@Override
	public Shoe makeShoe() {
		return new LeatherShoe();
	}
}

class LakhaniShoeFactory extends ShoeFactory {
	@Override
	public Shoe makeShoe() {
		return new SportsShoe();
	}
}

interface Seller {
	
}

interface ShoeSeller extends Seller {
	public Shoe sellShoe(Customer customer);
}

abstract class ShoeShop implements ShoeSeller {
	private ShoeFactory shoeFactory;

	public final ShoeFactory getShoeFactory() {
		return shoeFactory;
	}

	public final void setShoeFactory(ShoeFactory shoeFactory) {
		this.shoeFactory = shoeFactory;
	}
}

class GokulShoeShop extends ShoeShop {
	@Override
	public Shoe sellShoe(Customer customer) {
		System.out.println("Shoe purchased by " + customer.getCustomerName());
		return getShoeFactory().makeShoe();
	}
}

abstract class Shoe {
	private ShoeShop shoeShop;

	public final ShoeShop getShoeShop() {
		return shoeShop;
	}

	public final void setShoeShop(ShoeShop shoeShop) {
		this.shoeShop = shoeShop;
	}
}

class LeatherShoe extends Shoe {
	@Override
	public String toString() {
		return "Leather Shoe";
	}
}

class SportsShoe extends Shoe {
	@Override
	public String toString() {
		return "Sports Shoe";
	}
}

abstract class Customer {
	private String customerName;
	public Customer(String customerName) {
		this.setCustomerName(customerName);
	}
	public final String getCustomerName() {
		return customerName;
	}
	public final void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}

class ShoeCustomer extends Customer {
	public ShoeCustomer(String customerName) {
		super(customerName);
	}
}
