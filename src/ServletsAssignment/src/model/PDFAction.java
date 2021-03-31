package model;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import invoice.TotalDetails;
import service.ShoppingService;
import service.ShoppingServiceImpl;

/**
 * Servlet implementation class PDFAction
 */
public class PDFAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("PDF Create");
		Properties prop = (Properties) request.getServletContext().getAttribute("properties");
		HttpSession session = request.getSession();
		ShoppingService shoppingService = ShoppingServiceImpl.getShoppingServiceImpl(prop);
		TotalDetails totaldetails = (TotalDetails) session.getAttribute("totaldetails");
		System.out.println("Totaldetails" + totaldetails);
		shoppingService.createXML((Integer) session.getAttribute("invno"), totaldetails);
		shoppingService.createPDF((Integer) session.getAttribute("invno"), totaldetails.getInvdate());
		return "shop3";
	}

}
