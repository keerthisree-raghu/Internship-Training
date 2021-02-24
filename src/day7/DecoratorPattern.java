package day7;

public class DecoratorPattern {
	public static void main(String[] args) {
		IceCream cream = new Nuts(new Vanilla(new DryFruit(new TuttyFruity())));
		System.out.println("Cost of vanilla ice cream: " + cream.cost());;
	}
}

abstract class IceCream {
	public abstract int cost();
}

abstract class Cream extends IceCream {}

abstract class IceCreamIngredients extends IceCream {}

class Vanilla extends Cream {
	IceCream iceCream;
	public Vanilla() {
		// TODO Auto-generated constructor stub
	}
	public Vanilla(IceCream iceCream) {
		this.iceCream = iceCream;
	}
	@Override
	public int cost() {
		if(this.iceCream == null) {
			return 10;
		}
		else {
			return 10 + this.iceCream.cost();
		}
	}
}

class Strawberry extends Cream {
	IceCream iceCream;
	public Strawberry() {
		// TODO Auto-generated constructor stub
	}
	public Strawberry(IceCream iceCream) {
		this.iceCream = iceCream;
	}
	@Override
	public int cost() {
		if(this.iceCream == null) {
			return 15;
		}
		else {
			return 15 + this.iceCream.cost();
		}
	}
}

class TuttyFruity extends Cream {
	IceCream iceCream;
	public TuttyFruity() {
		// TODO Auto-generated constructor stub
	}
	public TuttyFruity(IceCream iceCream) {
		this.iceCream = iceCream;
	}
	@Override
	public int cost() {
		if(this.iceCream == null) {
			return 20;
		}
		else {
			return 20 + this.iceCream.cost();
		}
	}
}

class DryFruit extends Cream {
	IceCream iceCream;
	public DryFruit(IceCream iceCream) {
		this.iceCream = iceCream;
	}
	@Override
	public int cost() {
		if(this.iceCream == null) {
			return 5;
		}
		else {
			return 5 + this.iceCream.cost();
		}
	}
}

class Nuts extends Cream {
	IceCream iceCream;
	public Nuts(IceCream iceCream) {
		this.iceCream = iceCream;
	}
	@Override
	public int cost() {
		if(this.iceCream == null) {
			return 10;
		}
		else {
			return 10 + this.iceCream.cost();
		}
	}
}