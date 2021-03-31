package day24;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:3000/ws/hello?wsdl");

		QName qName = new QName("http://day24/", "HelloServiceImplService");

		Service service = Service.create(url, qName);

		HelloService hservice = service.getPort(HelloService.class);

		String result = hservice.sayHello("Ramu");
		System.out.println("The result is: " + result);
	}
}
