<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<title>List Passengers</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
		  integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</head>

<body class="bg-info">
<div class="container bg-primary">
	<h2 class="text-center">Passenger Management</h2>
</div>

<div class="container">
	<input type="button" class="btn btn-success" value="Add Passenger"
		   onclick="window.location.href='showFormForAdd'; return false;"/>
	<div class="table-responsive">
		<table class="table table-striped table-dark table-hover mt-3 text-center">
			<thead>
			<tr>
				<th scope="col">First Name</th>
				<th scope="col">Family Name</th>
				<th scope="col">Date of Birth</th>
				<th scope="col">Email</th>
				<th scope="col">Phone</th>
				<th scope="col">Gender</th>
				<th scope="col">Payment</th>
				<th scope="col">Action</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="tempPassenger" items="${passengers}">
				<c:url var="updateLink" value="/passenger/showFormForUpdate">
					<c:param name="passengerId" value="${tempPassenger.passengerId}" />
				</c:url>
				<c:url var="deleteLink" value="/passenger/delete">
					<c:param name="passengerId" value="${tempPassenger.passengerId}" />
				</c:url>
				<c:url var="flightLink" value="/passenger/showFormForFlight">
					<c:param name="passengerId" value="${tempPassenger.passengerId}" />
				</c:url>
				<tr>
					<td> ${tempPassenger.name} </td>
					<td> ${tempPassenger.family} </td>
					<td> ${tempPassenger.birthdate} </td>
					<td> ${tempPassenger.email} </td>
					<td> ${tempPassenger.phone} </td>
					<td> ${tempPassenger.gender} </td>
					<td> ${tempPassenger.payment} </td>
					<td>
						<a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}"
						   onclick="if (!(confirm('Are you sure you want to delete this passenger?'))) return false">Delete</a>
						|
						<a href="${flightLink}">ShowFlight</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>

</html>