package day16;

/*
 * format specifier -> % + formatting instruction
 * [flag] -> + (default) or - (padding to the right side)
 * [width] -> how many characters in padding (spaces)
 * [.] (precision) -> specify number of decimal places in floating point values
 * s, d, f -> string, integer, float
 */

public class StringFormatting {
	public static void main(String[] args) {
//		System.out.printf("formatting instruction", "input");
		System.out.printf("Integer value: %d\n", 200); // %d - integer
		System.out.printf("String value: %s\n", "Hello World"); // %s - string
		System.out.printf("Float value: %f\n", 20.5f); // %f - float
//		method(1, 2, 3, 4, 5);
		String s = String.format("\nString: %s, Integer: %06d, Float: %.3f", "Hello World", 60, 20.3f);
		System.out.println(s);
		System.out.printf("\n%-15s%-15s%s", "Column1", "Column2", "Column3");
	}
	public static void method(int... integers) {
		for(int i : integers) {
			System.out.println(i);
		}
	}
}
