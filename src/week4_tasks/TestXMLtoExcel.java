package week4_tasks;

public class TestXMLtoExcel {
	public static void main(String[] args) throws Exception {
		XMLtoExcelConverter xmlToExcel = new XMLtoExcelConverter();
		xmlToExcel.convertXMLtoExcel(args[0]);
	}
}