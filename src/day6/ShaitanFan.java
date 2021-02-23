package day6;

import java.util.Scanner;

public class ShaitanFan {
	public static void main(String[] args) throws Exception {
//		BadFan shaitan = new BadFan();
		GoodFan khaitan = new GoodFan();
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("Press a letter to change the fan speed:");
			scan.next();
//			shaitan.pull();
			khaitan.pull();
		}
	}
}

// if-else-if chain
class BadFan{
	int state = 0;
	public void pull() {
		if(state == 0) {
			System.out.println("Switch On");
			state = 1;
		}
		else if(state == 1) {
			System.out.println("Medium Speed");
			state = 2;
		}
		else if(state == 2) {
			System.out.println("High Speed");
			state = 3;
		}
		else if(state == 3) {
			System.out.println("Switch Off");
			state = 0;
		}
	}
}