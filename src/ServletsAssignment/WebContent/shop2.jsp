<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="invoice.ItemMasterDTO"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.HashMap"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Grocery Shop</title>
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
</head>
<body>
	<div>
		<div class="container">

			<form action="shopping.do" method="post">
				<input type="hidden" name="formid" value="shopping"> <input
					type="hidden" name="shopid" value="fruits"> <input
					type="hidden" name="currentid" value="grocery">
				<div class="row h-100 justify-content-center align-items-center">
					<div class="col-auto">
						<div class="col-sm text-center">
							<h1>Grocery Shop</h1>
						</div>
						<hr>
						<table border="1" class="table w-auto table-responsive">
							<tr>
								<th>Item Image</th>
								<th>Item Name</th>
								<th>Item Quantity</th>
								<th>Item Price</th>
								<th>Select</th>
							</tr>

							<c:forEach items="${items}" var="item">
								<tr>
									<td><img src=<c:out value='${item.getImageURL()}'/>
										width="100" height="100" class="img-thumbnail"></td>
									<td><span>${item.getItemDescription()}</span></td>
									<td><select class="form-control"
										name=<c:out value='${item.getItemNo()}' />>
											<option value="0">Select quantity</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
									</select></td>
									<td><span>${item.getItemPrice()}</span></td>
									<td><input class="form-control" type="checkbox"
										name="selected" value=<c:out value='${item.getItemNo()}' />></td>
								</tr>
							</c:forEach>
						</table>
						<div class="col-sm text-center">
							<input type="submit" value="Fruits Shop" class="btn btn-success">
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>