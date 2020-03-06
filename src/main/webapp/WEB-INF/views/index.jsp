<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Building Manager</title>
</head>
<body>
	<div align="center">
		<h1>Building : ${message}</h1>
		<form method="get" action="search">
			<input type="text" name="keyword" /> <input type="submit"
				value="Search" />
		</form>

		<br>

		<table>
			<tr>
				<th>ID</th>
				<th>Names</th>
				<th>E-mail</th>
				<th>Address</th>
				<th>Action</th>
			</tr>
			<c:forEach item="${listCustomer}" var="customer">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.name}</td>
					<td>${customer.email}</td>
					<td>${customer.address}</td>
					<td><a href="edit?id=${net.codejava.customer.id}">Edit</a></td>
					&nbsp;&nbsp;&nbsp;
					<td><a href="delete?id=${net.codejava.customer.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>