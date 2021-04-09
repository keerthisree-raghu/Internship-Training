package springtransactions;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		BusinessBean bb = context.getBean("businessadvisedbean", BusinessBean.class);

		bb.doTransaction(1, 2, 1000);
	}
}
