package day13;

public class GenericsDemo3 {
	// Accepts any type, returns any type
	public <E> E getObject(E[] elements)  {
		for(E element : elements) {
			System.out.println(element);
		}
		return null;
	}
	public static void main(String[] args) {
		GenericsDemo3 object = new GenericsDemo3();
		object.getObject(new String[] {"a", "b", "c"});
		object.getObject(new Integer[] {1, 2, 3});
	}
}

class Test {
	
}
