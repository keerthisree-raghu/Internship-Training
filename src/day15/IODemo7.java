package day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class IODemo7 {
	public static void main(String[] args) throws Exception {
		Laddu laddu = new Laddu();
		System.out.println("Size of original laddu is " + laddu.size);

		laddu.size = 5;
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("laddu.dat"));
		oos.writeObject(laddu);

		laddu.size = 2;
		System.out.println("Size of modified laddu is " + laddu.size);
		System.out.println("I want the old laddu.");

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("laddu.dat"));
		Laddu laddu2 = (Laddu)ois.readObject(); // Deep copy of laddu

		System.out.println("Original laddu size: " + laddu2.size);
		System.out.println("Modified laddu size: " + laddu.size);
	}
}

class Laddu implements Serializable {
	public Laddu() {
		System.out.println("Laddu object created.");
	}
	int size = 10;
}