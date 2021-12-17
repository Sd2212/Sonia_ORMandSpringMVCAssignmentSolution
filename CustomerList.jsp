<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<title>Customer Relationship Management</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 5px;
}

tr:nth-child(even) {
	background-color: #8F9AA5;
}
</style>
</head>

<body>

	<div class="container">

		<div
			style="background-color: #ADD8E6; padding: 20px 20px; margin-bottom: 40px; text-align: centEr">
			<h3 class="font-weight-bold" style="color: black"
				style="text-align:center">Customer Relationship Management</h3>
		</div>


		<a href="/Customer_Relation_Management/customer/Add"
			class="btn btn-primary btn-sm mb-3"> Add Customer </a>


		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email ID</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${CustomerRelations}" var="temp">
					<tr>
						<td><c:out value="${temp.firstname}" /></td>
						<td><c:out value="${temp.lastname}" /></td>
						<td><c:out value="${temp.emailid}" /></td>
						<td>
							<!-- Add "update" button/link --> <a
							href="/Customer_Relation_Management/customer/Update?custId=${temp.id}"
							class="btn btn-info btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a
							href="/Customer_Relation_Management/customer/Delete?custId=${temp.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">
								Delete </a>


						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>
</html>