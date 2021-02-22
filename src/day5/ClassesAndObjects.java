package day5;

public class ClassesAndObjects {
	public static void main(String[] args) {
		Pepsi pepsi = new Pepsi();
		Kalimark kalimark = new Kalimark();
		pepsi.makePepsi();
		kalimark.makeBovonto();
	}
}

abstract class Soda {
	public abstract void makeSoda();
}

class Pepsi {
	public void makePepsi() {
		// Cannot access inner class (CocaCola) in Kalimark
		// Soda soda = new CocaCola();
		// Can be accessed through Kalimark
		// Soda soda = new Kalimark().new CocaCola();
		// Soda soda = new Kalimark().getColaTrojan();
		// soda.makeSoda();
		// System.out.println("Pepsi sells CocaCola in Pepsi bottle.");
	}
}

class Kalimark {
	int money = 50;
	public void makeBovonto() {
		// Anonymous inner class
		new Soda() {
			@Override
			public void makeSoda() {
				System.out.println("CocaCola belongs to Kalimark. It is not called Kalimark soda.");
			}
		}.makeSoda();
	}
//	public void makeBovonto() {
//		// Inner classes in methods are more private - Local inner class
//		class CocaCola extends Soda {
//			int cocacolaMoney = 70;
//			@Override
//			public void makeSoda() {
//				// TODO Auto-generated method stub
//				// Properties of Kalimark can be accessed in CocaCola
//				System.out.println("Soda made by CocaCola costs Rs." + money);
//			}
//		}
//		Soda soda = new CocaCola();
//		soda.makeSoda();
//		// We cannot directly access a variable from within the inner class
//		System.out.println("Kalimark sells CocaCola in Kalimark bottle. It costs Rs." + new CocaCola().cocacolaMoney);
//	}
	
	// Inner class - part of the outer class
	// Outside classes cannot access this class without the permission of the outer class
	// Can only access CocaCola through an object of Kalimark
//	private class CocaCola extends Soda {
//		int cocacolaMoney = 70;
//		@Override
//		public void makeSoda() {
//			// TODO Auto-generated method stub
//			// Properties of Kalimark can be accessed in CocaCola
//			System.out.println("Soda made by CocaCola costs Rs." + money);
//		}
//	}
//	public Soda getColaTrojan() {
//		return new CocaCola();
//	}
}