<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<h1>Register</h1>
	<form action="register.do" method="post">
		<input type="hidden" name="formid" value="register">
		UserID: <input type="text" name="userId"> 
		Username: <input type="text" name="username"> 
		Password: <input type="password" name="password">
		<input type="submit" value="Register">
	</form>
</body>
</html>