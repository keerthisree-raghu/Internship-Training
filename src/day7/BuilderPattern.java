package day7;

public class BuilderPattern {
	public static void main(String[] args) {
		// Accessing a static inner class - ComputerBuilder
		// Computer with only basic (fixed) features
		Computer computer = new Computer.ComputerBuilder("HDD Computer", "16GB RAM").build();
		System.out.println(computer);
		// Computer with optional features
		Computer computer2 = new Computer.ComputerBuilder("HDD Computer", "32GB RAM").
				setBluetooth("Bluetooth Enabled").
				setGraphicsCard("Game Graphics Card Inserted").build();
		System.out.println(computer2);
	}
}

class Computer {
	// Fixed properties
	private String HDD;
	private String RAM;
	
	// Ad-hoc (optional) properties
	private String graphicsCard;
	private String bluetooth;
	
	// Build output string
	@Override
	public String toString() {
		return "Computer [HDD=" + HDD + ", RAM=" + RAM + ", graphicsCard=" + graphicsCard + ", bluetooth=" + bluetooth+ "]";
	}

	// Constructor which accepts properties from ComputerBuilder
	public Computer(ComputerBuilder builder) {
		this.HDD = builder.getHDD();
		this.RAM = builder.getRAM();
		this.bluetooth = builder.getBluetooth();
		this.graphicsCard = builder.getGraphicsCard();
	}

	// Inner class
	public static class ComputerBuilder {
		// Fixed properties
		private String HDD;
		private String RAM;
		
		// Ad-hoc (optional) properties
		private String graphicsCard;
		private String bluetooth;
		
		// Constructor
		public ComputerBuilder(String HDD, String RAM) {
			this.HDD = HDD;
			this.RAM = RAM;
		}
		
		// Getters and setters to access properties outside the class
		public final String getHDD() {
			return HDD;
		}

		public final void setHDD(String hDD) {
			HDD = hDD;
		}

		public final String getRAM() {
			return RAM;
		}

		public final void setRAM(String rAM) {
			RAM = rAM;
		}
		public final String getGraphicsCard() {
			return graphicsCard;
		}

		public final ComputerBuilder setGraphicsCard(String graphicsCard) {
			this.graphicsCard = graphicsCard;
			return this;
		}

		public final String getBluetooth() {
			return bluetooth;
		}

		public final ComputerBuilder setBluetooth(String bluetooth) {
			this.bluetooth = bluetooth;
			return this;
		}
		
		// Computer is built based on the parameters provided in ComputerBuilder
		public Computer build() {
			return new Computer(this);
		}
	}
}