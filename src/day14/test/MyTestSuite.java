package day14.test;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	MyTestCase.class, 
	MyTestCase2.class
})
public class MyTestSuite {

}
