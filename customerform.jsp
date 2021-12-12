<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Save Customer Details</title>
</head>

<body>

	<div class="container">

		<h3>Customer Relationship Management</h3>
		<hr>

		<p class="h4 mb-4">Customer Data</p>

		<form action="/Customer_Relationship_Management/customers/Save"
			method="POST">


			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${CustomerRelation.id}" />


			<div class="form-inline">
				<input type="text" name="firstname"
					value="${CustomerRelation.firstname}"
					class="form-control mb-4 col-4" placeholder="FirstName">
			</div>

			<div class="form-inline">
				<input type="text" name="lastname"
					value="${CustomerRelation.lastname}"
					class="form-control mb-4 col-4" placeholder="LastName">
			</div>


			<div class="form-inline">

				<input type="text" name="emailid"
					value="${CustomerRelation.emailid}" class="form-control mb-4 col-4"
					placeholder="Email Id">
			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/Customer_Relationship_Management/customers/list">Back to
			Customers List</a>

	</div>
</body>

</html>
