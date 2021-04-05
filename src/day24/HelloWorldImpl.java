package day24;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(endpointInterface = "day24.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
	@Resource
	WebServiceContext wsContext;
	
	@Override
	public String getHelloWorldAsString() {
		MessageContext msgContext = wsContext.getMessageContext();
		
		// Get details from request headers
		Map http_headers = (Map) msgContext.get(MessageContext.HTTP_REQUEST_HEADERS);
		List userList = (List) http_headers.get("Username");
		List passList = (List) http_headers.get("Password");
		
		String username = "";
		String password = "";
		
		if(userList != null) {
			username = userList.get(0).toString();
		}
		
		if(passList != null) {
			password = passList.get(0).toString();
		}
		
		if(username.equals("ramu") && password.equals("secret")) {
			return "Hello, world! JAX-WS valid user.";
		}
		else {
			return "Unknown user.";
		}
	}
	
}
