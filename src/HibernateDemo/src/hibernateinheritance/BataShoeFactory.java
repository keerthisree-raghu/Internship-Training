package hibernateinheritance;

public class BataShoeFactory extends ShoeFactory {
	private String bataName;

	public String getBataName() {
		return bataName;
	}

	public void setBataName(String bataName) {
		this.bataName = bataName;
	}
	
	public void visit() {
		new Handler().handle(this);
	}
}
