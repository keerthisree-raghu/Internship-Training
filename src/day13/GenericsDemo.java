package day13;

public class GenericsDemo {
	public static void main(String[] args) {
		// Type of paint brush is water
		PaintBrush<Water> brush = new PaintBrush<>();
		brush.object = new Water(); 
		Water water = brush.getObject();
		System.out.println(water);
		// Type of paint brush is paint
		PaintBrush<Paint> brush2 = new PaintBrush<>();
		brush2.object = new RedPaint();
		Paint paint = brush2.getObject();
		System.out.println(paint);
	}
}

//Generics - Shows errors at compile time rather than run time

class PaintBrush<T> {
	// Return type of the object is specified at runtime
	T object;
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
}

abstract class Paint {
	
}

class RedPaint extends Paint {
	
}

class Water {
	
}