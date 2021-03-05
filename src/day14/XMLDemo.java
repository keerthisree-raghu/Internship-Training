package day14;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLDemo {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		// Set validation to true
		dbf.setIgnoringElementContentWhitespace(true); // Eliminate white spaces while parsing
		dbf.setValidating(true);

		DocumentBuilder db = dbf.newDocumentBuilder();
		
		// Parse XML file
		Document doc = db.parse("books.xml");
		
		// Get node name and number of child nodes
		System.out.println(doc.getDocumentElement().getNodeName());
		System.out.println(doc.getDocumentElement().getChildNodes().getLength());
		

		Element rootElement = doc.getDocumentElement();
		
		// Iterate through all child nodes
		for (int i = 0; i < rootElement.getChildNodes().getLength(); i++) {
			for (int j = 0; j < rootElement.getChildNodes().item(i).getChildNodes().getLength(); j++) {
				System.out.println(rootElement.getChildNodes().item(i).getChildNodes().item(j).getNodeName());
			}
		}
		
		// Get node name of first child
		System.out.println(rootElement.getFirstChild().getNodeName());
		// nodeType: 1 - Element, 2 - Attribute, 3 - Text
		System.out.println(rootElement.getFirstChild().getFirstChild().getFirstChild().getNodeType());
	}
}