package day12;

public class LambdaDemo {
	public static void main(String[] args) {
		display(new MyInterface() {
			@Override
			public void method() {
				System.out.println("Anonymous: My interface method is called.");
			}
//			@Override
//			public void method2() { }
		});
		
		// The syntax of lambda is only possible on functional interfaces
		// Functional interface - an interface with only one method
		// Runnable and Callable are functional interfaces - lambda can be used
		display(() -> {
			System.out.println("Lambda: My interface method is called.");
		});
		// Lambda with parameters
		display2((msg, i) -> {
			System.out.println(msg + ": " + i);
		});
		// Lambda with return type
		String result = displayReturn((name, i) -> {
			return name + ": " + i;
		});
		System.out.println("Result: " + result);
	}
	public static void display(MyInterface mi) {
		mi.method();
	}
	public static void display2(MyInterface2 mi2) {
		mi2.method2("Hello, world", 0);
	}
	public static String displayReturn(MyInterface3 mi3) {
		return mi3.method3("Foo bar", 5);
	}
}

interface MyInterface3 {
	public String method3(String s, int i);
}

interface MyInterface2 {
	public void method2(String s, int i);
}

@FunctionalInterface // Will throw an error if more than one method is declared
interface MyInterface {
	public void method();
//	public void method2(); // Error (Lambda): The target type of the expression must be an interface
}

class MyInterfaceImplementation implements MyInterface {
	@Override
	public void method() {
		System.out.println("Outer implementation: My interface method is called.");
	}
//	@Override
//	public void method2() { }
}
