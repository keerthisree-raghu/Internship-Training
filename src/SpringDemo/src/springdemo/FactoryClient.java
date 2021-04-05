package springdemo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryClient {
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		
		GokulShoeShop seller = context.getBean("shop", GokulShoeShop.class);
		
//		ShoeShop shop = (ShoeShop)context.getBean("shop");
//		
		Customer customer = new ShoeCustomer("John Doe");
//		
//		System.out.println(shop.getFactory());
//		
//		System.out.println(shop.sellShoe(customer));
		
//		ShoeSeller seller = context.getBean("shoe", ShoeSeller.class);
//		
		Shoe shoe = seller.sellShoe(customer);
//		
		System.out.println(shoe);
		
		GokulShoeShop seller2 = seller.getClone();
		
		System.out.println(seller2.getName());
		System.out.println(seller2.getMylist());
		
		context.close();
	}
}
