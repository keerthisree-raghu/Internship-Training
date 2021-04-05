package day24;

import java.util.Iterator;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.soap.SOAPFaultException;


public class MacAddressValidatorHandler implements SOAPHandler<SOAPMessageContext> {

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		System.out.println("Server: handleMessage()");
		Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
		
		// For response message only, true for outbount messages, false for inbound messages
		if(!isRequest) {
			try {
				SOAPMessage soapMessage = context.getMessage();
				SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
				SOAPHeader soapHeader = soapEnvelope.getHeader();
				
				if(soapHeader == null) {
					// Add header if there is no header
					soapHeader = soapEnvelope.addHeader();
					// Throw exception
					generateSOAPErrMessage(soapMessage, "No soap header.");
				}
				
				Iterator it = soapHeader.extractHeaderElements(SOAPConstants.URI_SOAP_ACTOR_NEXT);
				
				// If no header block for next actor, throw exception
				if(it == null || !it.hasNext()) {
					generateSOAPErrMessage(soapMessage, "No header block for next actor.");
				}
				
				// If no mac address found, throw error
				Node macNode = (Node) it.next();
				String macValue = (macNode == null ? null : macNode.getValue());
				
				if(macValue == null) {
					generateSOAPErrMessage(soapMessage, "No mac address in header block.");
				}
				
				// If mac address does not match, throw exception
				if(!macValue.equals("98-E7-F4-8A-63-96")) {
					generateSOAPErrMessage(soapMessage, "Invalid mac address, access denied.");
				}
				
				// Tracking
				soapMessage.writeTo(System.out);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// Continue to other handler chain
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("Server: handleFault()");
		return true;
	}

	@Override
	public void close(MessageContext context) {
		System.out.println("Server: close()");
	}

	@Override
	public Set<QName> getHeaders() {
		System.out.println("Server: getHeaders()");
		return null;
	}
	
	private void generateSOAPErrMessage(SOAPMessage soapMessage, String reason) {
		try {
			SOAPBody soapBody = soapMessage.getSOAPPart().getEnvelope().getBody();
			SOAPFault soapFault = soapBody.addFault();
			soapFault.setFaultString(reason);
			throw new SOAPFaultException(soapFault);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
