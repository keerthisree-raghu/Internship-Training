<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invoice</title>
</head>
<body>
	<%
	Enumeration<String> e = session.getAttributeNames();
	while (e.hasMoreElements()) {
		String name = e.nextElement();
		String value = (String) session.getAttribute(name);
		out.println("<h1>" + name + ": " + value + "</h1>");
	}
	%>
</body>
</html>