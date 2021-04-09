package inheritance;

public class VisitorImpl implements Visitor {

	public void process(Automobile bsf) {
		System.out.println("Automobile processed.");
	}

	public void process(Car lsf) {
		// TODO Auto-generated method stub
		System.out.println("Car processed.");
	}

	public void process(Maruti sf) {
		System.out.println("Maruti processed.");
	}
}
