package day6;

public class TemplateMethod {
	public static void main(String[] args) {
		DominosPizza dominos = new CoimbatoreDominos();
		dominos.makePizza();
	}
}

abstract class DominosPizza {
	final public void chooseCrust() {
		System.out.println("Crust selected.");
	}
	final public void chooseToppings() {
		System.out.println("Toppings chosen.");
	}
	final public void chooseSides() {
		System.out.println("Sides chosen.");
	}
	final public void customizePizza() {
		chooseCrust();
		chooseToppings();
		chooseSides();
	}
	// Methods to be overriden
	public abstract void makePizza();
	public abstract void deliverPizza();
}

class CoimbatoreDominos extends DominosPizza {
	@Override
	public void makePizza() {
		customizePizza();
		System.out.println("Preparing...");
		deliverPizza();
	}
	@Override
	public void deliverPizza() {
		System.out.println("Pizza delivered.");
	}
}