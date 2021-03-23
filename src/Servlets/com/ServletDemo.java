package com;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletDemo", urlPatterns = { "/Servlet Demo" })
public class ServletDemo extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init method is called");
		String value = config.getInitParameter("abc");
		System.out.println(value);

		Enumeration<String> e = config.getInitParameterNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			String value1 = config.getInitParameter(name);
			System.out.println(name + ":" + value1);
		}

		ServletContext context = config.getServletContext(); // ServletContext is a global object
		context.setAttribute("GlobalKey", "GlobalValue"); // This key can be read across the servlets
		String path = context.getRealPath("/WEB-INF/dbconfig.properties");
		System.out.println(path);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet method is called.");
		ServletOutputStream out = response.getOutputStream();
		response.setContentType("text/html");

		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		out.println("<h2>" + uname + ": " + pass);

		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			String value = request.getParameter(name);
			System.out.println(name + ": " + value);
		}
		if (uname.equals("john")) {
//			response.sendRedirect("welcome.html");
			RequestDispatcher rd = request.getRequestDispatcher("welcome.html");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost method is called.");
		doGet(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("Destroy method is called");
	}
}
