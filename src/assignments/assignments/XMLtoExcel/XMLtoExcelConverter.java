package assignments.XMLtoExcel;

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

interface WriteToExcel {
	public void convertXMLtoExcel(String filePath) throws Exception;
}

public class XMLtoExcelConverter implements WriteToExcel {
	private static Workbook workbook;
	private static int rowNum = 0;
	
	// Initialize fields as variables
	private final static int INVOICE_NO = 0;
	private final static int INVOICE_DATE = 1;
	private final static int CUSTOMER_NAME = 2;
	private final static int ITEM_NO = 3;
	private final static int ITEM_NAME = 4;
	private final static int ITEM_PRICE = 5;
	private final static int QUANTITY = 6;
	private final static int AMOUNT = 7;
	private final static int GST = 8;
	private final static int NET_TOTAL = 9;
	
	// Initialize XLS 
	private static void initializeXLSWorkbook() {
		workbook = new XSSFWorkbook();
		
		CellStyle style = workbook.createCellStyle();
		Font boldFont = workbook.createFont();
		boldFont.setBold(true);
		style.setFont(boldFont);
		
		Sheet sheet = workbook.createSheet();
		Row row = sheet.createRow(rowNum++);
		
		// Format column headers
		Cell cell = row.createCell(INVOICE_NO);
		cell.setCellValue("Invoice Number");
		cell.setCellStyle(style);
		
		cell = row.createCell(INVOICE_DATE);
		cell.setCellValue("Invoice Date");
		cell.setCellStyle(style);
		
		cell = row.createCell(CUSTOMER_NAME);
		cell.setCellValue("Customer Name");
		cell.setCellStyle(style);
		
		cell = row.createCell(ITEM_NO);
		cell.setCellValue("Item Number");
		cell.setCellStyle(style);
		
		cell = row.createCell(ITEM_NAME);
		cell.setCellValue("Item Name");
		cell.setCellStyle(style);
		
		cell = row.createCell(ITEM_PRICE);
		cell.setCellValue("Item Price");
		cell.setCellStyle(style);
		
		cell = row.createCell(QUANTITY);
		cell.setCellValue("Quantity");
		cell.setCellStyle(style);
		
		cell = row.createCell(AMOUNT);
		cell.setCellValue("Amount");
		cell.setCellStyle(style);
		
		cell = row.createCell(GST);
		cell.setCellValue("GST");
		cell.setCellStyle(style);
		
		cell = row.createCell(NET_TOTAL);
		cell.setCellValue("Net Total");
		cell.setCellStyle(style);
	}
	
	// Parse XML file and convert to excel
	@Override
	public void convertXMLtoExcel(String filePath) throws Exception {
		// Initialize XML file
		File xmlFile = new File(filePath);
		
		initializeXLSWorkbook();
		
		Sheet sheet = workbook.getSheetAt(0);
		
		// Parse XML file
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		
		NodeList nodeList = doc.getElementsByTagName("invoice");
		int nodeListSize = nodeList.getLength();
		
		for(int i = 0; i < nodeListSize; i++) {
			System.out.println("Processing invoice...");
			Node node = nodeList.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				String invoiceNo = element.getElementsByTagName("invoiceNo").item(0).getTextContent();
				String invoiceDate = element.getElementsByTagName("invoiceDate").item(0).getTextContent();
				String customerName = element.getElementsByTagName("customerName").item(0).getTextContent();
				String gst = element.getElementsByTagName("gst").item(0).getTextContent();
				String netTotal = element.getElementsByTagName("netTotal").item(0).getTextContent();
				
				NodeList items = element.getElementsByTagName("item");
				int itemsSize = items.getLength();
				
				Row row = sheet.createRow(rowNum++);
				
				Cell cell = row.createCell(INVOICE_NO);
				cell.setCellValue(invoiceNo);
				
				cell = row.createCell(INVOICE_DATE);
				cell.setCellValue(invoiceDate);
				
				cell = row.createCell(CUSTOMER_NAME);
				cell.setCellValue(customerName);
				
				for(int j = 0; j < itemsSize; j++) {
					Node eachItem = items.item(j);
					if(eachItem.getNodeType() == Node.ELEMENT_NODE) {
						Element it = (Element) eachItem;
						String itemNo = it.getElementsByTagName("itemNo").item(0).getTextContent();
						String itemName = it.getElementsByTagName("itemName").item(0).getTextContent();
						String itemPrice = it.getElementsByTagName("itemPrice").item(0).getTextContent();
						String quantity = it.getElementsByTagName("quantity").item(0).getTextContent();
						String amount = it.getElementsByTagName("amount").item(0).getTextContent();
					
						row = sheet.createRow(rowNum++);
						
						cell = row.createCell(ITEM_NO);
						cell.setCellValue(itemNo);;
						
						cell = row.createCell(ITEM_NAME);
						cell.setCellValue(itemName);
						
						cell = row.createCell(ITEM_PRICE);
						cell.setCellValue(itemPrice);;
						
						cell = row.createCell(QUANTITY);
						cell.setCellValue(quantity);;
						
						cell = row.createCell(AMOUNT);
						cell.setCellValue(amount);
					}
				}
				row = sheet.createRow(rowNum++);
				
				cell = row.createCell(GST);
				cell.setCellValue(gst);
				
				cell = row.createCell(NET_TOTAL);
				cell.setCellValue(netTotal);
			}
		}
		
		FileOutputStream fileOut = new FileOutputStream("C:/workspace/EYInternshipTraining/assignment/RMIServer/Output/Converted-Invoice-Excel.xlsx");
		workbook.write(fileOut);
		workbook.close();
		fileOut.close();
		
		System.out.println("The XML format invoice file has been successfully converted to an Excel file.");
	}
}