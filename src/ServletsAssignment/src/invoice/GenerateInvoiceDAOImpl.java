package invoice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.Properties;
//import javax.mail.Authenticator;
//import javax.mail.BodyPart;
//import javax.mail.Message;
//import javax.mail.Multipart;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
//import com.twilio.Twilio;
//import com.twilio.*;
//import com.twilio.rest.api.v2010.account.*;
//import com.twilio.type.PhoneNumber;

public class GenerateInvoiceDAOImpl implements GenerateInvoiceDAO, Cloneable {
	private static GenerateInvoiceDAOImpl generateInvoice;
	private Properties prop;

	private GenerateInvoiceDAOImpl(Properties prop) {
		this.prop = prop;
	}

	synchronized public static GenerateInvoiceDAOImpl generateInvoiceImpl(Properties prop) {

		if (generateInvoice == null) {
			generateInvoice = new GenerateInvoiceDAOImpl(prop);
			return generateInvoice;
		} else {
			return generateInvoice.createClone();
		}
	}

	public GenerateInvoiceDAOImpl createClone() {
		try {
			return (GenerateInvoiceDAOImpl) super.clone();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void createXML(int invoiceNo, TotalDetails details) {
		try {
			StringBuilder sb = new StringBuilder();
			int customerId = details.getCustomermasterdto().getCustomerId();
			String customerName = details.getCustomermasterdto().getCustomerName();
			String customerAddress = details.getCustomermasterdto().getCustomerAddress();
			String customerEmail = details.getCustomermasterdto().getCustomerEmail();
			String customerPhone = details.getCustomermasterdto().getCustomerPhone();
			sb.append("<!DOCTYPE invoice SYSTEM \"invoice.dtd\"><invoice><customer>");
			sb.append("<customerid>" + customerId + "</customerid>"
					+ "<customername>" + customerName + "</customername>"
					+ "<customeraddress>" + customerAddress + "</customeraddress>"
					+ "<customeremail>" + customerEmail + "</customeremail>"
					+ "<customerphone>" + customerPhone + "</customerphone>"
					+ "<invoiceno>" + invoiceNo + "</invoiceno>"
					+ "</customer>");
			sb.append("<items>");
			for (ItemDetails item : details.getItemdetails()) {
				int itemNo = item.getItemNo();
				String itemName = item.getItemDescription();
				int itemPrice = item.getItemPrice();
				int itemQuantity = item.getItemQuantity();
				String itemUnit = item.getItemUnit();
				sb.append("<item>");
				sb.append("<itemno>" + itemNo + "</itemno>"
						+ "<itemname>" + itemName + "</itemname>" 
						+ "<itemprice>" + itemPrice + "</itemprice>"
						+ "<itemqty>" + itemQuantity + "</itemqty>"
						+ "<itemunit>" + itemUnit + "</itemunit>"
						+ "<itemtotal>" + itemQuantity * itemPrice + "</itemtotal>");
				sb.append("</item>");
			}
			sb.append("</items></invoice>");
			File output = new File("C:/workspace/ServletsAssignment/" + invoiceNo + ".xml");
			FileWriter fwriter = new FileWriter(output);
			fwriter.write(sb.toString());
			fwriter.flush();
			fwriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void createPDF(int invoiceNo) {
		XMLtoPDFConverter convertToPDF = new XMLtoPDFConverter();
		try {
			String filePath = "C:/workspace/ServletsAssignment/" + invoiceNo + ".xml";
			String pathToSave = "C:/workspace/ServletsAssignment/" + invoiceNo + ".pdf";
			convertToPDF.convertXMLtoPDF(filePath, pathToSave);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void createExcel(int invoiceNo, String invdate) {
		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			OutputStream fileOut = new FileOutputStream("C:/workspace/ServletsAssignment/" + invoiceNo + ".xls");
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("Bill_Sheet");
			HSSFCellStyle style = workbook.createCellStyle();
			HSSFFont font = workbook.createFont();
			font.setBold(true);
			style.setFont(font);
			HSSFCellStyle style1 = workbook.createCellStyle();
			HSSFFont font1 = workbook.createFont();
			font1.setBold(true);
			style1.setFont(font);
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 2, 4));
			HSSFRow rowhead = sheet.createRow((short) 0);
			rowhead.setRowStyle(style1);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setIgnoringElementContentWhitespace(true);
			dbf.setValidating(true);
			sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 2));
			sheet.addMergedRegion(new CellRangeAddress(1, 1, 3, 4));
			sheet.addMergedRegion(new CellRangeAddress(2, 2, 1, 2));
			sheet.addMergedRegion(new CellRangeAddress(2, 2, 3, 4));
			sheet.addMergedRegion(new CellRangeAddress(3, 3, 1, 2));
			sheet.addMergedRegion(new CellRangeAddress(3, 3, 3, 4));
			sheet.addMergedRegion(new CellRangeAddress(4, 4, 1, 2));
			sheet.addMergedRegion(new CellRangeAddress(4, 4, 3, 4));
			sheet.addMergedRegion(new CellRangeAddress(5, 5, 1, 2));
			sheet.addMergedRegion(new CellRangeAddress(5, 5, 3, 4));
			sheet.addMergedRegion(new CellRangeAddress(6, 6, 1, 2));
			sheet.addMergedRegion(new CellRangeAddress(6, 6, 3, 4));
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse("C:/workspace/ServletsAssignment/" + invoiceNo + ".xml");
			Element rootElement = doc.getDocumentElement();
			HSSFRow row1 = sheet.createRow((short) (1));
			row1.createCell(1).setCellValue("Customer ID");
			row1.createCell(3).setCellValue(
					rootElement.getChildNodes().item(0).getChildNodes().item(0).getFirstChild().getNodeValue());
			HSSFRow row2 = sheet.createRow((short) (2));
			row2.createCell(3).setCellValue(
					rootElement.getChildNodes().item(0).getChildNodes().item(1).getFirstChild().getNodeValue());
			row2.createCell(1).setCellValue("Customer Name");
			HSSFRow row3 = sheet.createRow((short) (3));
			row3.createCell(3).setCellValue(
					rootElement.getChildNodes().item(0).getChildNodes().item(2).getFirstChild().getNodeValue());
			row3.createCell(1).setCellValue("Customer Address");
			HSSFRow row4 = sheet.createRow((short) (4));
			row4.createCell(3).setCellValue(
					rootElement.getChildNodes().item(0).getChildNodes().item(3).getFirstChild().getNodeValue());
			row4.createCell(1).setCellValue("Customer Email");
			HSSFRow row5 = sheet.createRow((short) (5));
			row5.createCell(3).setCellValue(
					rootElement.getChildNodes().item(0).getChildNodes().item(4).getFirstChild().getNodeValue());
			row5.createCell(1).setCellValue("Customer Phone");
			HSSFRow row6 = sheet.createRow((short) (6));
			row6.createCell(3).setCellValue(
					rootElement.getChildNodes().item(0).getChildNodes().item(5).getFirstChild().getNodeValue());
			row6.createCell(1).setCellValue("Invoice No");
			HSSFRow row0 = sheet.createRow((short) 7);
			row0.createCell(0).setCellValue("Item No");
			row0.createCell(1).setCellValue("Description");
			row0.createCell(2).setCellValue("Price");
			row0.createCell(3).setCellValue("Quantity");
			row0.createCell(4).setCellValue("Unit");
			row0.createCell(5).setCellValue("Total");
			for (int j = 0; j <= 5; j++)
				row0.getCell(j).setCellStyle(style);
			for (int i = 1; i < rootElement.getChildNodes().getLength(); i++) {
				for (int j = 0; j < rootElement.getChildNodes().item(i).getChildNodes().getLength(); j++) {
					HSSFRow row = sheet.createRow((short) (j + 8));
					for (int k = 0; k < rootElement.getChildNodes().item(i).getChildNodes().item(j).getChildNodes()
							.getLength(); k++) {
						row.createCell(k).setCellValue(rootElement.getChildNodes().item(i).getChildNodes().item(j)
								.getChildNodes().item(k).getFirstChild().getNodeValue());
					}
				}
			}
			System.out.println("Generated Excel Invoice");
			workbook.write(fileOut);
			wb.write(fileOut);
			wb.close();
			fileOut.close();
		} catch (Exception e) {
		}

	}

	@Override
	public void sendMail(String name, String email, int invoiceNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendSMS(String phone, TotalDetails details) {
		// TODO Auto-generated method stub

	}

//	@Override
//	public void sendMail(String name, String email, int invoiceNo) {
//		String host = "smtp.gmail.com";
//		Properties properties = System.getProperties();
//		System.out.println("PROPERTIES " + properties);
//		properties.put("mail.smtp.host", host);
//		properties.put("mail.smtp.port", "465");
//		properties.put("mail.smtp.ssl.enable", "true");
//		properties.put("mail.smtp.auth", "true");
//		Session session = Session.getInstance(properties, new Authenticator() {
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication("saiprasaad1999@gmail.com", "**********");
//			}
//		});
//		session.setDebug(true);
//		MimeMessage m = new MimeMessage(session);
//		try {
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress("saiprasaad1999@gmail.com"));
//			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
//			message.setSubject("Bill Receipt");
//
//			BodyPart messageBodyPart = new MimeBodyPart();
//			messageBodyPart.setText("Hi " + name + "\n" + "Here is your bill");
//			MimeBodyPart attachmentPart = new MimeBodyPart();
//			attachmentPart.attachFile(new File("~" + invoiceNo + ".pdf"));
//			Multipart multipart = new MimeMultipart();
//			multipart.addBodyPart(messageBodyPart);
//			multipart.addBodyPart(attachmentPart);
//			message.setContent(multipart);
//			Transport.send(message);
//			System.out.println("Email Sucessfully Sent");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	@Override
//	public void sendSMS(String phone, TotalDetails details) {
//		final String ACCOUNT_SID = "**********************************";
//		final String AUTH_TOKEN = "***********************************";
//		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//		String to = "";
//		String message = "";
//		to = phone;
//		message = "Hello " + details.getCustomermasterdto().getCustomername() + "\n";
//		StringBuilder sb = new StringBuilder();
//		sb.append("Items:" + "\n");
//		int i = 1;
//		for (ItemDetails id : details.getItemdetails()) {
//			sb.append("Item " + i + " :" + "\n");
//			sb.append("Item No:" + id.getItemno() + "\n");
//			sb.append("Item Description: " + id.getItemdescription() + "\n" + "Item Price: " + id.getItemprice() + "\n"
//					+ "Item Quantity: " + id.getItemqty() + "\n" + "Item Unit: " + id.getItemunit() + "\n"
//					+ "Item Total: " + id.getItemqty() * id.getItemprice());
//			sb.append("\n");
//			i++;
//		}
//		message = message + sb.toString();
//		System.out.println(to);
//		System.out.println(message);
//		com.twilio.rest.api.v2010.account.Message messageobj = com.twilio.rest.api.v2010.account.Message
//				.creator(new PhoneNumber(to), new PhoneNumber("+12107022886"), message).create();
//		System.out.println(messageobj.getSid());
//	}
}
