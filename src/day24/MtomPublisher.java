package day24;

import javax.xml.ws.Endpoint;

public class MtomPublisher {
	public static void main(String[] args) {
		System.out.println("Service ready.");
		Endpoint.publish("http://localhost:3000/ws/hello", new MtomService());
	}
}
