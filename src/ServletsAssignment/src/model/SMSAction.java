package model;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import invoice.TotalDetails;
import service.ShoppingService;
import service.ShoppingServiceImpl;

public class SMSAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Properties prop = (Properties) request.getServletContext().getAttribute("properties");
		HttpSession session = request.getSession();
		ShoppingService shoppingService = ShoppingServiceImpl.getShoppingServiceImpl(prop);
		TotalDetails totaldetails = (TotalDetails) session.getAttribute("totaldetails");
//		shoppingService.sendSMS(totaldetails, session.getAttribute("custno"));
		return "shop3";
	}

}
