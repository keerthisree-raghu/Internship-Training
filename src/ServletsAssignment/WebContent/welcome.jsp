<!DOCTYPE html>
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
<meta charset="ISO-8859-1">
<title>Welcome!</title>
</head>
<body>
	<form action="shopping.do" method="post">
		<input type="hidden" name="formid" value="shopping"> <input
			type="hidden" name="shopid" value="jewellery">
		<div class="container h-100">
			<div class="row h-100 justify-content-center align-items-center">
				<header class="text-center text-white py-5 mb-5">
					<h1 class="font-weight-bold text-dark">
						Welcome, <%=session.getAttribute("username")%>!</h1>
					<h3 class="text-dark">
						<input type="submit" value="Shop Now"
							class="btn btn-success">
					</h3>
				</header>
			</div>
		</div>
	</form>

	<form action="logout.do" method="post">
		<input type="hidden" name="formid" value="logout">
		<div class="text-center">
			<input type="submit" value="Logout" class="btn btn-danger">
		</div>
	</form>

</body>
</html>