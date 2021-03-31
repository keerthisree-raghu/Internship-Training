<!DOCTYPE html>
<%@page import="java.util.ResourceBundle"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"
	integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div class="container">
		<h1>Login</h1>
		<div class="card">
			<div class="card-body">
				<form action="login.do;jsessionid=<%=session.getId()%>" method="post">
					<input type="hidden" name="formid" value="login">
					<div class="form-group row">
						<label for="firstName" class="col-sm-2 col-form-label">Username</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="username"
								placeholder="Enter username">
						</div>
					</div>

					<div class="form-group row">
						<label for="lastName" class="col-sm-2 col-form-label">Password</label>
						<div class="col-sm-7">
							<input type="password" class="form-control" name="password"
								placeholder="Enter password">
						</div>
					</div>

					<button type="submit" class="btn btn-primary">Login</button>
				</form>
			</div>
		</div>
	</div>
	<!-- 
	<form action="login.do;jsessionid=<%=session.getId()%>" method="post">
	<input type="hidden" name="formid" value="login">
		Username:<input type="text" name="username">
		Password:<input type="password" name="password">
		<input type="submit" value="Login">
	</form>
	 -->
</body>
</html>