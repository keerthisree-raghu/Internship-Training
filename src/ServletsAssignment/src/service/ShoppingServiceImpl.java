package service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

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

import invoice.CustomerMasterDAO;
import invoice.CustomerMasterDAOImpl;
import invoice.CustomerMasterDTO;
import invoice.GenerateInvoiceDAO;
import invoice.GenerateInvoiceDAOImpl;
import invoice.InvoiceMasterDAO;
import invoice.InvoiceMasterDAOImpl;
import invoice.InvoiceMasterDTO;
import invoice.ItemDetails;
import invoice.ItemMasterDAO;
import invoice.ItemMasterDAOImpl;
import invoice.ItemMasterDTO;
import invoice.ItemTransactionMasterDAO;
import invoice.ItemTransactionMasterDAOImpl;
import invoice.ItemTransactionMasterDTO;
import invoice.TotalDetails;
import invoice.UserDAO;
import invoice.UserDAOImpl;

public class ShoppingServiceImpl implements Cloneable, ShoppingService {
	Properties prop;

	public ShoppingServiceImpl(Properties prop) {
		this.prop = prop;
	}

	private static ShoppingServiceImpl shoppingServiceImpl;

	public static ShoppingServiceImpl getShoppingServiceImpl(Properties prop) {
		if (shoppingServiceImpl == null) {
			shoppingServiceImpl = new ShoppingServiceImpl(prop);
			return shoppingServiceImpl;
		} else {
			return shoppingServiceImpl.createClone();
		}
	}

	public ShoppingServiceImpl createClone() {
		try {
			return (ShoppingServiceImpl) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Set<ItemMasterDTO> loadAllItems(String category) {
		Set<ItemMasterDTO> itemmasterdtoset = new HashSet<ItemMasterDTO>();
		ItemMasterDAO itemDao = ItemMasterDAOImpl.getItemDAOImpl(prop);
		itemmasterdtoset = itemDao.getItemMasterAll(category);
		return itemmasterdtoset;
	}

	@Override
	public Set<ItemMasterDTO> buyItems(Set<ItemTransactionMasterDTO> itemtransactionmasterdtoset) {
		ItemTransactionMasterDAO itemtransactiondao = ItemTransactionMasterDAOImpl
				.getItemTransactionMasterDAOImpl(prop);
		Set<ItemMasterDTO> items = new HashSet<ItemMasterDTO>();
		for (ItemTransactionMasterDTO itemtransactionmasterdto : itemtransactionmasterdtoset) {
			itemtransactiondao.insertItem(itemtransactionmasterdto);
			ItemMasterDTO itemmasterdto = new ItemMasterDTO();
			ItemMasterDAO itemmasterdao = ItemMasterDAOImpl.getItemDAOImpl(prop);
			itemmasterdto = itemmasterdao.getItemMaster(itemtransactionmasterdto.getItemno());
			items.add(itemmasterdto);
		}
		return items;
	}

	@Override
	public int getInvNo(int custno, String dateinstring) {
		InvoiceMasterDAO invoicemaster = InvoiceMasterDAOImpl.getInvoiceMasterDAOImpl(prop);
		InvoiceMasterDTO invmasterdto = new InvoiceMasterDTO();
		invmasterdto.setCustomerId(custno);
		invmasterdto.setInvoiceDate(dateinstring);
		int invno = invoicemaster.insertInvoice(invmasterdto);
		return invno;
	}

	@Override
	public CustomerMasterDTO getCustomerDetails(int customerno) {
		CustomerMasterDAO customerdao = CustomerMasterDAOImpl.getCustomerMasterDAOImpl(prop);
		CustomerMasterDTO customerdto = new CustomerMasterDTO();
		customerdto = customerdao.getCustomerMaster(customerno);
		return customerdto;
	}

	@Override
	public Set<ItemDetails> getItemDetails(int invno) {
		ItemTransactionMasterDAO itemtransactionmasterdao = ItemTransactionMasterDAOImpl
				.getItemTransactionMasterDAOImpl(prop);
		Set<ItemDetails> itemdetails = new HashSet<ItemDetails>();
		itemdetails = itemtransactionmasterdao.getItemDetails(invno);
		return itemdetails;
	}

	@Override
	public String getInvdate(int invno) {
		InvoiceMasterDAO invoicemasterdao = InvoiceMasterDAOImpl.getInvoiceMasterDAOImpl(prop);
		String date = invoicemasterdao.getDate(invno);
		return date;
	}

	@Override
	public void createPDF(int invoiceNo, String invdate) {
		GenerateInvoiceDAO filecreationdao = GenerateInvoiceDAOImpl.generateInvoiceImpl(prop);
		filecreationdao.createPDF(invoiceNo);
	}

	@Override
	public void createExcel(int invno, String invdate) {
		GenerateInvoiceDAO filecreationdao = GenerateInvoiceDAOImpl.generateInvoiceImpl(prop);
		filecreationdao.createExcel(invno, invdate);
	}

	@Override
	public void createXML(int invno, TotalDetails totaldetails) {
		GenerateInvoiceDAO filecreationdao = GenerateInvoiceDAOImpl.generateInvoiceImpl(prop);
		filecreationdao.createXML(invno, totaldetails);
	}

	@Override
	public void sendMail(String name, int invno, int custno) {
		GenerateInvoiceDAO exportbilldao = GenerateInvoiceDAOImpl.generateInvoiceImpl(prop);
		CustomerMasterDAO customermasterdao = CustomerMasterDAOImpl.getCustomerMasterDAOImpl(prop);
		String email = customermasterdao.getEmail(custno);
		exportbilldao.sendMail(name, email, invno);

	}

	@Override
	public void sendSMS(TotalDetails totaldetails, int custno) {
		GenerateInvoiceDAO exportbilldao = GenerateInvoiceDAOImpl.generateInvoiceImpl(prop);
		CustomerMasterDAO customermasterdao = CustomerMasterDAOImpl.getCustomerMasterDAOImpl(prop);
		String phone = "+91" + customermasterdao.getPhoneNo(custno);
		exportbilldao.sendSMS(phone, totaldetails);

	}

}
