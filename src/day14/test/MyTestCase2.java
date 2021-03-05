package day14.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyTestCase2 {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Set up before class is executed...");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Tear down after class is executed...");
	}
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Set up executed...");
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Tear down expected...");
	}
	
	@Test
	public void test1() {
		System.out.println("Test 1 method called...");
	}
	
	@Test
	public void test2() {
		System.out.println("Test 2 method called...");
	}
	
	@Test
	public void test3() {
		System.out.println("Test 3 method called...");
	}
}
