package day14;

import java.io.FileWriter;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLDemo2 {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		// Set validation to true
		dbf.setValidating(true); // A DTD must exist
		dbf.setIgnoringElementContentWhitespace(true); // Eliminate white space while parsing
		
		DocumentBuilder db = dbf.newDocumentBuilder();
		// Parse XML file
		Document doc = db.parse("books.xml");
		
		// Get root element
		Element rootElement = doc.getDocumentElement();

		Node newNode = doc.createElement("NewElement");
		Node newData = doc.createTextNode("NewData");
		Node newAttr = doc.createAttribute("Attribute");
		Node newAttrValue = doc.createTextNode("Value");

		newAttr.appendChild(newAttrValue);
		newNode.getAttributes().setNamedItem(newAttr);

		newNode.appendChild(newData);

		rootElement.insertBefore(newNode.cloneNode(true), rootElement.getFirstChild());

		rootElement.appendChild(newNode.cloneNode(true));

		Transformer transform = TransformerFactory.newInstance().newTransformer();
		transform.setOutputProperty(OutputKeys.INDENT, "yes");

		DOMSource domSource = new DOMSource(doc);

		StringWriter sw = new StringWriter();
		StreamResult sr = new StreamResult(sw);

		transform.transform(domSource, sr);

		System.out.println(sw.toString());

		FileWriter out = new FileWriter("newbooks.xml");
		out.write(sw.toString());
		out.close();
	}
}