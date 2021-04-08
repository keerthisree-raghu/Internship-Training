package hibernateinheritance;

public class ShoeFactory {
	private int shoeId;
	private String name;
	
	public int getShoeId() {
		return shoeId;
	}
	public void setShoeId(int shoeId) {
		this.shoeId = shoeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ShoeFactory [shoeId=" + shoeId + ", name=" + name + "]";
	}
	
	public void visit() {
		new Handler().handle(this);
	}
}
