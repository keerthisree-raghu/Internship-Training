package day24;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "day24.HelloService")
@HandlerChain(file = "day24/handler-chain.xml")
public class HelloServiceImpl implements HelloService {
	@WebMethod
	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return "Welcome to SOAP-based standard web services: " + name;
	}
}
