package day24;

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

public class HelloWorldClient {
	private static final String WS_URL = "http://localhost:3000/ws/hello?wsdl";
	public static void main(String[] args) throws Exception {
		URL url = new URL(WS_URL);
		QName qName = new QName("http://day24/", "HelloWorldImplService");

		Service service = Service.create(url, qName);

		HelloWorld hello = service.getPort(HelloWorld.class);
		
		Map<String, Object> req_ctx = ((BindingProvider)hello).getRequestContext();
		
		req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);
		
		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		
		headers.put("Username", Collections.singletonList("ramu"));
		
		headers.put("Password", Collections.singletonList("secret"));
		
		req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		
		System.out.println(hello.getHelloWorldAsString());
	}
}
