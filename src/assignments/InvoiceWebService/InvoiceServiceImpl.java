package assignments.InvoiceWebService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

import assignments.Consignment.ConsignmentDetails;
import assignments.Consignment.ConsignmentTracker;
import assignments.CreateXMLFile.GenerateXML;
import assignments.XMLtoExcel.XMLtoExcelConverter;
import assignments.XMLtoPDF.XMLtoPDFConverter;
import invoiceDatabase.Customer;
import invoiceDatabase.InvoiceMaster;
import invoiceDatabase.Items;
import invoiceDatabase.ItemsMaster;
import invoiceDatabase.ItemsMasterDTO;

@WebService(endpointInterface = "assignments.InvoiceWebService.InvoiceService")
@HandlerChain(file = "assignments/InvoiceWebService/handler-chain.xml")
public class InvoiceServiceImpl implements InvoiceService {
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	@WebMethod
	@Override
	public void generateInvoiceMethod(int choice, int invoiceNumber) {
		switch (choice) {
		case 1:
			try {
				createNewInvoice(invoiceNumber);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				trackConsignment(invoiceNumber);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				generateInvoiceExcel(invoiceNumber);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 4:
			try {
				generateInvoicePDF(invoiceNumber);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 5:
			try {
				addNewItem();
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("Invalid choice. Enter a choice value between 1 and 5.");
		}
	}

	public void createNewInvoice(int invoiceNumber) throws Exception {
		InvoiceMaster invoiceMaster = new InvoiceMaster();
		Customer customer = new Customer();
		ItemsMaster itemsMaster = new ItemsMaster();
		Items items = new Items();

		int invoiceNo = invoiceMaster.getInvoiceMaster(invoiceNumber).getInvoiceNumber();
		String invoiceDate = String.valueOf(invoiceMaster.getInvoiceMaster(invoiceNumber).getInvoiceDate());
		int customerID = invoiceMaster.getInvoiceMaster(invoiceNumber).getCustomerID();

		String customerName = customer.getCustomerDetails(customerID).getCustomerName();
		String customerAddress = customer.getCustomerDetails(customerID).getCustomerAddress();
		String customerPhone = customer.getCustomerDetails(customerID).getCustomerPhone();
		String customerEmail = customer.getCustomerDetails(customerID).getCustomerEmail();

		System.out.print("Enter number of items: ");
		int numberOfItems = Integer.parseInt(input.readLine());

		int itemNumber = 0;
		String itemDescription = "";
		float itemPrice = 0.0f;
		int itemQuantity = 0;
		double total = 0;

		for (int i = 0; i < numberOfItems; i++) {
			itemNumber = items.getItemDetails(invoiceNumber).getItemNumber();
			itemDescription = itemsMaster.getItemDetailsMaster(itemNumber).getItemDescription();
			itemPrice = itemsMaster.getItemDetailsMaster(itemNumber).getItemPrice();
			itemQuantity = itemsMaster.getItemDetailsMaster(itemNumber).getItemQuantity();

			total += (itemPrice * itemQuantity);
		}

		System.out.println("Invoice Number: " + invoiceNo);
		System.out.println("Invoice Date: " + invoiceDate);
		System.out.println("Customer ID: " + customerID + "\tCustomer Name: " + customerName);
		System.out.println("Customer Address: " + customerAddress + "\tCustomer Phone Number: " + customerPhone
				+ "\tCustomer Email ID: " + customerEmail);

		System.out.println("Item Number\tItem Description\tItem Price\tItem Quantity");
		for (int i = 0; i < numberOfItems; i++) {
			System.out.println(itemNumber + "\t" + itemDescription + "\t" + itemPrice + "\t" + itemQuantity + "\n");
		}

		System.out.println("Total: " + total);
	}

	public void trackConsignment(int invoiceNumber) throws Exception {
		ConsignmentTracker consignmentTracker = new ConsignmentTracker();
		ConsignmentDetails consignmentDetails = new ConsignmentDetails();

		consignmentTracker.calculateArrivalDate(consignmentDetails, invoiceNumber);
	}

	public void generateInvoicePDF(int invoiceNumber) throws Exception {
		GenerateXML generateXML = new GenerateXML();
		String filePath = generateXML.generateXMLInvoice(generateXML.convertDataToString(invoiceNumber));

		XMLtoPDFConverter pdfConverter = new XMLtoPDFConverter();
		pdfConverter.convertXMLtoPDF(filePath);
	}

	public void generateInvoiceExcel(int invoiceNumber) throws Exception {
		GenerateXML generateXML = new GenerateXML();
		String filePath = generateXML.generateXMLInvoice(generateXML.convertDataToString(invoiceNumber));

		XMLtoExcelConverter excelConverter = new XMLtoExcelConverter();
		excelConverter.convertXMLtoExcel(filePath);
	}

	public void addNewItem() throws Exception {
		ItemsMasterDTO itemsMasterDTO = new ItemsMasterDTO();
		ItemsMaster itemsMaster = new ItemsMaster();

		System.out.print("Enter number of items: ");
		int numberOfItems = Integer.parseInt(input.readLine());

		int rowsInserted = 0;

		for (int i = 0; i < numberOfItems; i++) {
			System.out.print("Enter item number: ");
			itemsMasterDTO.setItemNumber(Integer.parseInt(input.readLine()));

			System.out.print("Enter item description: ");
			itemsMasterDTO.setItemDescription(input.readLine());

			System.out.print("Enter item price: ");
			itemsMasterDTO.setItemPrice(Float.parseFloat(input.readLine()));

			System.out.print("Enter item quantity: ");
			itemsMasterDTO.setItemQuantity(Integer.parseInt(input.readLine()));

			rowsInserted += itemsMaster.insertItemMasterDetails(itemsMasterDTO);
		}
		System.out.println(rowsInserted);
	}
}
