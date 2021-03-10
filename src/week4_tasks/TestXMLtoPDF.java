package week4_tasks;

public class TestXMLtoPDF {
	public static void main(String[] args) throws Exception {
		XMLtoPDFConverter xmlToPDF = new XMLtoPDFConverter();
		xmlToPDF.convertXMLtoPDF(args[0]);
//		xmlToPDF.convertXMLtoPDF("C:/workspace/EYInternshipTraining/invoice.xml");
	}
}
