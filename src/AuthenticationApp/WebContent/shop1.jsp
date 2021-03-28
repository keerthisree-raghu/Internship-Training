<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jewellery Shop</title>
</head>
<body bgcolor="yellow">
	<hr>
	<jsp:include page="logout.jsp"></jsp:include>
	<hr>
	<h1>Jewellery Shop</h1>
	<form action="shop.do" method="post">
		<input type="hidden" name="formId" value="shop">
		<input type="hidden" name="shopId" value="shop1"> 
		Bangles: <input type="checkbox" name="c1" value="bangle"> 
		Necklace: <input type="checkbox" name="c2" value="necklace"> 
		Chain: <input type="checkbox" name="c3" value="chain"> 
		<input type="submit" value="Next Shop">
	</form>
</body>
</html>