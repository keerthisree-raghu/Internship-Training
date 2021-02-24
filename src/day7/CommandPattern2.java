package day7;

public class CommandPattern2 {
	static ESeva eseva;
	static {
		Police police = new Police();
		Hospital hospital = new Hospital();
		Corporation corporation = new Corporation();
		FoodSafety foodsafety = new FoodSafety();
		eseva = new ESeva();
		eseva.setGovtCommand(new HotelOpenGovtCommand(police, hospital, corporation, foodsafety), 0);
		eseva.setGovtCommand(new ForeignDeathGovtCommand(police, hospital, corporation, foodsafety), 1);
		eseva.setGovtCommand(new OrphanDeathGovtCommand(police, hospital, corporation, foodsafety), 2);
	}
	public static void main(String[] args) {
		eseva.executeGovtCommand(2);
	}
}

class ESeva {
	GovtCommand c[] = new GovtCommand[5];
	public ESeva() {
		for(int i = 0; i < 5; i++) {
			c[i] = new DummyGovtCommand();
		}
	}
	public void executeGovtCommand(int slot) {
		c[slot].execute();
	}
	public void setGovtCommand(GovtCommand c, int slot) {
		this.c[slot] = c;
	}
	class DummyGovtCommand extends GovtCommand {
		@Override
		public void execute() {
			System.out.println("Dummy GovtCommand");
		}
	}
}

abstract class GovtCommand {
	Police police;
	Hospital hospital;
	Corporation corporation;
	FoodSafety foodsafety;
	public GovtCommand() {
		
	}
	public GovtCommand(Police police, Hospital hospital, Corporation corporation, FoodSafety foodsafety) {
		this.police = police;
		this.hospital = hospital;
		this.corporation = corporation;
		this.foodsafety = foodsafety;
	}
	
	public abstract void execute();
}

class HotelOpenGovtCommand extends GovtCommand {
	public HotelOpenGovtCommand(Police police, Hospital hospital, Corporation corporation, FoodSafety foodsafety) {
		super(police, hospital, corporation, foodsafety);
	}
	@Override
	public void execute() {
		System.out.println("Hotel opening process has been started.");
		foodsafety.checkPremises();
		corporation.verifyDeath();
		police.givePoliceCertificate();
		foodsafety.giveFSSCertificate();
		System.out.println("Hotel opening process is over.");
	}
}

class ForeignDeathGovtCommand extends GovtCommand {
	public ForeignDeathGovtCommand(Police police, Hospital hospital, Corporation corporation, FoodSafety foodsafety) {
		super(police, hospital, corporation, foodsafety);
	}
	@Override
	public void execute() {
		System.out.println("Foreign death certificate process has been started.");
		police.doPoliceInvestigation();
		police.givePoliceCertificate();
		corporation.verifyDeath();
		hospital.doPostMortem();
		corporation.giveDeathCertificate();
		hospital.arrangeTransport();
		System.out.println("Foreign death certificate process has been completed.");
	}
}

class OrphanDeathGovtCommand extends GovtCommand {
	public OrphanDeathGovtCommand(Police police, Hospital hospital, Corporation corporation, FoodSafety foodsafety) {
		super(police, hospital, corporation, foodsafety);
	}
	@Override
	public void execute() {
		System.out.println("Orphan death certificate process has been started.");
		hospital.doPostMortem();
		police.doPoliceInvestigation();
		police.givePoliceCertificate();
		corporation.giveDeathCertificate();
		System.out.println("Orphan death certificate process has been completed.");
	}
}

class Police {
	public void doPoliceInvestigation() {
		System.out.println("The police are doing investigation.");
	}
	public void givePoliceCertificate() {
		System.out.println("Police certificate has been given.");
	}
}

class Hospital {
	public void arrangeTransport() {
		System.out.println("Transportation for the body has been arranged.");
	}
	public void doPostMortem() {
		System.out.println("Post mortem has been completed by the hospital.");
	}
}

class Corporation {
	public void verifyDeath() {
		System.out.println("Death has been verified by the corporation.");
	}
	public void giveDeathCertificate() {
		System.out.println("Death certificate has been issued.");
	}
}

class FoodSafety {
	public void checkPremises() {
		System.out.println("Premises checked by Food Safety Department officials.");
	}
	public void giveFSSCertificate() {
		System.out.println("FSS Certificate has been issued.");
	}
}

