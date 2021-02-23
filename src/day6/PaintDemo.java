package day6;

public class PaintDemo {
	public static void main(String[] args) throws Exception {
		PaintBrush brush = PaintContainer.getBrush(args[0]);
		brush.doPaint();
	}
}

// This code is open for modification and closed for extension - bad code
class BadPaintBrush{
	public void doPaint(int i) {
		if(i == 1) {
			System.out.println("Red Paint");
		}
		else if(i == 2) {
			System.out.println("Blue Paint");
		}
		else {
			System.out.println("Black Paint");
		}
	}
}

/* Application Containers
 * The container is used to bring loose coupling
 * It creates new objects dynamically and injects the dependencies
 * It returns fully created objects 
 */ 

class PaintContainer {
	public static PaintBrush getBrush(String paintClass) throws Exception {
		PaintBrush brush = new PaintBrush();
		Paint paint = (Paint)Class.forName(paintClass).newInstance();
		// Dependency injection
		brush.paint = paint;
		return brush;
	}
}

/* When an if-else-if chain is encountered and the code is dynamic in nature
 * 1. Convert the conditions to classes
 * 2. Group them under a hierarchy
 * 3. Create an association between the using class and the hierarchical class
 */

class PaintBrush {
	Paint paint;
	public void doPaint() {
		System.out.println(paint);
	}
}

abstract class Paint {
	
}

// "Kinds of" the abstract class Paint

class RedPaint extends Paint {
	
}

class BluePaint extends Paint {
	
}