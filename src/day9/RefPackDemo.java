package day9;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RefPackDemo {
	public static void main(String[] args) throws Exception {
		PoliceStation police = (PoliceStation)Class.forName("day9.PoliceStation").getConstructor(new Class[] {String.class}).newInstance("hello");
		
		Politician politician = (Politician)Class.forName("day9.Politician").getConstructor().newInstance();
		police.arrest(politician);
		
		FakeDoctor doctor = new FakeDoctor();
//		police.arrest(doctor);
	}
}

class PoliceStation {
	public PoliceStation() {
		// TODO Auto-generated constructor stub
	}
	
	public PoliceStation(String s) {
		System.out.println("Overloaded string constructor of Police Station: " + s);
	}
	
	public void arrest(Object accused) throws Exception {
		Class c = accused.getClass();
		Field fields[] = c.getFields();
		for(Field f : fields) {
			System.out.println(f.getName());
		}
		Field field = c.getField("name");
		System.out.println(field.get(accused));
		
		Method method = c.getMethod("service", new Class[] {int.class});
		String value = (String)method.invoke(accused, new Object[] {Integer.valueOf(100)});
		
		System.out.println(value);
		
		field = c.getDeclaredField("secretName");
		field.setAccessible(true);
		System.out.println(field.get(accused));
		
		method = c.getDeclaredMethod("secretService", new Class[] {int.class});
		method.setAccessible(true);
		value = (String)method.invoke(accused, new Object[] {Integer.valueOf(100)});
		System.out.println(value);
	}
}	

class Politician {
	public Politician() {
		// TODO Auto-generated constructor stub
	}
	public String name = "Good Man";
	private String secretName = "Bad Man";
	public String service(int money) {
		return "Since you gave me money, I am your friend.";
	}
	private String secretService(int money) {
		return "Since I am a bad man, I will cheat you and take all your money.";
	}
}

class FakeDoctor {
	
}