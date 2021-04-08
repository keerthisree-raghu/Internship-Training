package hibernateinheritance;

public class LakhaniShoeFactory extends ShoeFactory {
	private String lakhaniName;

	public String getLakhaniName() {
		return lakhaniName;
	}

	public void setLakhaniName(String lakhaniName) {
		this.lakhaniName = lakhaniName;
	}
	
	public void visit() {
		new Handler().handle(this);
	}
}
