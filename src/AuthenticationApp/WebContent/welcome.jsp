<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h1>
		Welcome
		<%=session.getAttribute("username")%></h1>
	<hr>
	<jsp:include page="logout.jsp"></jsp:include>
	<hr>
	<form action="shopping.do" method="post">
		<input type="hidden" name="formId" value="shopping"> 
		<input type="submit" value="Shop">
	</form>
</body>
</html>