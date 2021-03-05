package day14.test;

import static org.junit.Assert.*;
import org.junit.Test;

public class MyTestCase {
	@Test
	public void test() {
		Calculator calculator = new Calculator();
		int result = calculator.add(10, 10);
		assertEquals(20, result); // Passes
//		assertEquals(10, result); // Fails
	}

}
