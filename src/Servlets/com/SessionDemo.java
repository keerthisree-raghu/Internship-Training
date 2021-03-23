package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDemo extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		ServletOutputStream out = response.getOutputStream();
		Object obj = session.getAttribute("count");
		if (obj == null) {
			// if(session.isNew()) {
			session.setAttribute("count", 2);
			out.println("<h1>You are visiting for the first time.</h1>");
		} else {
			out.println("<h1>Welcome back!</h1>" + obj.toString());
			String s = obj.toString();
			int x = Integer.parseInt(s);
			session.setAttribute("count", ++x);
		}
	}

}
