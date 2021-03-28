<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Grocery Shop</title>
</head>
<body bgcolor="blue">
	<hr>
	<jsp:include page="logout.jsp"></jsp:include>
	<hr>
	<h1>Grocery Shop</h1>
	<form action="shop.do" method="post">
		<input type="hidden" name="formId" value="shop"> 
		<input type="hidden" name="shopId" value="shop2"> 
		Daal: <input type="checkbox" name="c4" value="Daal"> 
		Rice: <input type="checkbox" name="c5" value="Rice"> 
		Channa: <input type="checkbox" name="c6" value="Chana"> 
		<input type="submit" value="Next Shop">
	</form>
</body>
</html>