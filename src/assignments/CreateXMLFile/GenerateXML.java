package assignments.CreateXMLFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import invoiceDatabase.Customer;
import invoiceDatabase.InvoiceMaster;
import invoiceDatabase.Items;
import invoiceDatabase.ItemsMaster;

public class GenerateXML {
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public String convertDataToString(int invoiceNumber) throws Exception {
		InvoiceMaster invoiceMaster = new InvoiceMaster();
		Customer customer = new Customer();
		ItemsMaster itemsMaster = new ItemsMaster();
		Items items = new Items();

		int invoiceNo = invoiceMaster.getInvoiceMaster(invoiceNumber).getInvoiceNumber();
		String invoiceDate = String.valueOf(invoiceMaster.getInvoiceMaster(invoiceNumber).getInvoiceDate());
		int customerID = invoiceMaster.getInvoiceMaster(invoiceNumber).getCustomerID();

		String customerName = customer.getCustomerDetails(customerID).getCustomerName();

		System.out.print("Enter number of items: ");
		int numberOfItems = Integer.parseInt(input.readLine());

		int itemNumber = 0;
		String itemDescription = "";
		float itemPrice = 0.0f;
		int itemQuantity = 0;
		double grandTotal = 0.0;

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<Invoice>" + " ");
		stringBuilder.append("<InvoiceNumber>" + invoiceNo + "</InvoiceNumber>" + " ");
		stringBuilder.append("<InvoiceDate>" + invoiceDate + "</InvoiceDate>" + " ");
		stringBuilder.append("<CustomerID>" + customerID + "</CustomerID>" + " ");
		stringBuilder.append("<CustomerName>" + customerName + "</CustomerName>" + " ");
		
		stringBuilder.append("<Items>");
		for (int i = 0; i < numberOfItems; i++) {
			double total = 0.0;
			itemNumber = items.getItemDetails(invoiceNumber).getItemNumber();
			itemDescription = itemsMaster.getItemDetailsMaster(itemNumber).getItemDescription();
			itemPrice = itemsMaster.getItemDetailsMaster(itemNumber).getItemPrice();
			itemQuantity = itemsMaster.getItemDetailsMaster(itemNumber).getItemQuantity();

			total = (itemPrice * itemQuantity);

			stringBuilder.append("<Item>");
			stringBuilder.append("<ItemNo>" + itemNumber + "</ItemNo>" + " ");
			stringBuilder.append("<ItemName>" + itemDescription + "</ItemName>" + " ");
			stringBuilder.append("<ItemPrice>" + itemPrice + "</ItemPrice>" + " ");
			stringBuilder.append("<Quantity>" + itemQuantity + "</Quantity>" + " ");
			stringBuilder.append("<Amount>" + total + "</Amount>" + " ");
			stringBuilder.append("</Item>");

			grandTotal += total;
		}
		stringBuilder.append("</Items>" + " ");
		
		stringBuilder.append("<GST>10</GST>" + " ");
		stringBuilder.append("<Total>" + grandTotal + "</Total>" + " ");
		stringBuilder.append("</Invoice>");

		StringTokenizer stringTokenizer = new StringTokenizer(stringBuilder.toString(), " ");

		String invoiceArray[] = new String[100];

		int count = 0;
		while (stringTokenizer.hasMoreElements()) {
			invoiceArray[count++] = stringTokenizer.nextToken().toString();
		}

		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < invoiceArray.length; i++) {
			stringBuffer.append(invoiceArray[i]);
		}
		String invoiceString = stringBuffer.toString();
		
		return invoiceString;
	}

	public String generateXMLInvoice(String xmlString) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document doc = builder.parse(new InputSource(new StringReader(xmlString)));

	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(doc);
	    
	    String filePath = "C:/workspace/EYInternshipTraining/assignments.RMIServer/Input/invoice.xml";
	    
	    StreamResult result =  new StreamResult(new File(filePath));
	    transformer.transform(source, result);
	    
	    return filePath;
	}
}
