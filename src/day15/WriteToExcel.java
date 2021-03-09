package day15;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WriteToExcel {
    public static void main(String[] args) {
    	XMLtoExcelConverter xmlConv = new XMLtoExcelConverter();
    	xmlConv.convertXMLtoExcel("invoice.xml");
	}
}

interface XMLConverterInterface { 
	public void convertXMLtoExcel(String filename);
}

class XMLtoExcelConverter implements XMLConverterInterface {
	private static Workbook workbook;
	private static int rowNum;
	public XMLtoExcelConverter() {
		workbook = new XSSFWorkbook();
		CellStyle style = workbook.createCellStyle();
		Font boldFont = workbook.createFont();
		boldFont.setBold(true);
		style.setFont(boldFont);
		Sheet sheet = workbook.createSheet();
		rowNum = 0;
		Row row = sheet.createRow(rowNum++);
	}
	@Override
	public void convertXMLtoExcel(String filepath) {
		try {
			File inputFile = new File(filepath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			Element rootElement = doc.getDocumentElement();
			Sheet sheet = workbook.getSheetAt(0);
			for (int i = 0; i < rootElement.getChildNodes().getLength(); i++) {
				System.out.println(rootElement.getChildNodes().getLength());
				NodeList nodes = rootElement.getChildNodes();
				for (int j = 0; j < rootElement.getChildNodes().item(i).getChildNodes().getLength(); j++) {
					Node node = nodes.item(j);
					if(node != null && node.getNodeType() == Node.ELEMENT_NODE) {
						Row row = sheet.createRow(rowNum++);
						Cell cell = row.createCell(j);
						cell.setCellValue(rootElement.getChildNodes().item(i).getChildNodes().item(j).getNodeName());
						System.out.println(rootElement.getChildNodes().item(i).getNodeName());
					}
				}
			}
			 FileOutputStream fileOut = new FileOutputStream("C:/Temp/Excel-Out.xlsx");
		     workbook.write(fileOut);
		     workbook.close();
		     fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}