package day17;

public class EnumDemo {
	public static void main(String[] args) {
		Cars car;
		car = Cars.maruti;
		method(car);
	}
	
	public static void method(Cars car) {
		if(car == Cars.maruti) {
			System.out.println("Maruti Car");
		}
		else if(car == Cars.fiat) {
			System.out.println("Fiat Car");
		}
		switch(car) {
			case maruti: {
				System.out.println("Maruti Car (switch)");
				break;
			}
			case fiat: {
				System.out.println("Fiat Car (switch)");
				break;
			}
			default: {
				System.out.println("Unknown");
			}
		}
		Cars cars[] = Cars.values();
		for(Cars c : cars) {
			System.out.println(c + ": " + c.getprice());
		}
		Cars.maruti.setPrice(500);
		System.out.println("Discounted Maruti Price: " + Cars.maruti.getprice());
	}
}

enum Cars {
	// By default, all are constants
	maruti(1000), tata(2000), fiat(3000), porche(4000), ferrari(5000);
	private int price;
	private Cars(int price) {
		this.price = price;
	}
	void setPrice(int price) {
		this.price = price;
	}
	public int getprice() {
		return this.price;
	}
}
