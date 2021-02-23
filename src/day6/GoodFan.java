package day6;

public class GoodFan {
	// Set a state variable to the initial state of SwitchedOff
	State state = new SwitchOffState();
	// Change state when pull method is called
	public void pull() {
		state.changeFanState(this);
	}
}

// Abstract parent class
abstract class State{
	// Abstract method to be overridden in child classes
	// Get object of GoodFan as the input parameter
	public abstract void changeFanState(GoodFan fan);
}

// Hierarchical classes
class SwitchOffState extends State{
	@Override
	public void changeFanState(GoodFan fan) {
		System.out.println("Switch On");
		// Change fan state to SwitchedOn
		fan.state = new SwitchOnState();
	}
}

class SwitchOnState extends State{
	@Override
	public void changeFanState(GoodFan fan) {
		System.out.println("Medium Speed");
		// Change fan state to MediumSpeed
		fan.state = new MediumSpeedState();
	}
}

class MediumSpeedState extends State{
	@Override
	public void changeFanState(GoodFan fan) {
		// TODO Auto-generated method stub
		System.out.println("High Speed");
		// Change fan state to HighSpeed
		fan.state = new HighSpeedState();
	}
}

class HighSpeedState extends State{
	@Override
	public void changeFanState(GoodFan fan) {
		System.out.println("Switch Off");
		// Change fan state to SwitchOff
		fan.state = new SwitchOffState();
	}
}