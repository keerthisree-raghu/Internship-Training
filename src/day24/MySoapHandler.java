package day24;

import java.io.PrintStream;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class MySoapHandler implements SOAPHandler<SOAPMessageContext> {
	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		try {
			System.out.println("handleMessage called for both request and response.");
			SOAPMessage sm = context.getMessage();
			PrintStream out = new PrintStream(System.out);
			sm.writeTo(out);
			out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		System.out.println("handleFault is called for both request and response when fault occurs.");
		return false;
	}

	@Override
	public void close(MessageContext context) {
		System.out.println("close is called when request and response closes.");
	}

	@Override
	public Set<QName> getHeaders() {
		System.out.println("getHeaders is called in the instantiation.");
		return null;
	}

}