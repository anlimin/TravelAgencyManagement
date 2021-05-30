<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Save Employee</title>
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
	<h3 class="text-success">Save Passenger</h3>
			<form:form class="row g-3" action="savePassenger" modelAttribute="allObjects" method="POST">
				<form:hidden path="passenger.passengerId" />
				<div class="col-md-6">
					<label for="passenger.name" class="col-form-label">First Name</label>
					<form:input type="text" class="form-control" path="passenger.name"/>
				</div>
				<div class="col-md-6">
					<label for="passenger.family" class="col-form-label">Last Name</label>
					<form:input type="text" class="form-control" path="passenger.family"/>
				</div>
				<div class="col-md-6">
					<label for="passenger.birthdate" class="col-form-label">Date of Birth</label>
					<form:input type="text" class="form-control" path="passenger.birthdate"/>
				</div>
				<div class="col-md-6">
					<label for="passenger.email" class="col-form-label">Email</label>
					<form:input type="text" class="form-control" path="passenger.email"/>
				</div>
				<div class="col-md-6">
					<label for="passenger.phone" class="col-form-label">Phone</label>
					<form:input type="text" class="form-control" path="passenger.phone"/>
				</div>
				<div class="col-md-2">
					<label class="col-form-label">Gender</label>
					<div class="form-control">
						<form:radiobutton class="form-check-input" path="passenger.gender" id="male" value="Male"/>
						<label class="form-check-label" for="male">Male</label>
						<form:radiobutton class="form-check-input" path="passenger.gender" id="female" value="Female"/>
						<label class="form-check-label" for="female">Female</label>
					</div>
				</div>
				<div class="col-md-4">
					<label class="col-form-label">Payment</label>
					<form:select class="form-select" path="passenger.payment">
						<form:options items="${allObjects.passenger.paymentOptions}"/>
					</form:select>
				</div>
				<form:hidden path="address.addressId" />
				<div class="col-md-6">
					<label for="address.number" class="col-form-label">Number</label>
					<form:input type="text" class="form-control" path="address.number"/>
				</div>
				<div class="col-md-6">
					<label for="address.street" class="col-form-label">Street</label>
					<form:input type="text" class="form-control" path="address.street"/>
				</div>
				<div class="col-md-6">
					<label for="address.city" class="col-form-label">City</label>
					<form:input type="text" class="form-control" path="address.city"/>
				</div>
				<div class="col-md-6">
					<label for="address.state" class="col-form-label">State</label>
					<form:input type="text" class="form-control" path="address.state"/>
				</div>
				<div class="col-md-6">
					<label for="address.country" class="col-form-label">Country</label>
					<form:input type="text" class="form-control" path="address.country"/>
				</div>
				<div class="col-md-6">
					<label for="address.postcode" class="col-form-label">Postcode</label>
					<form:input type="text" class="form-control" path="address.postcode"/>
				</div>
				<form:hidden path="flight.flightId" />
				<div class="col-md-6">
					<label class="col-form-label">Departure City</label>
					<form:input type="text" class="form-control" path="flight.fromCity"/>
				</div>
				<div class="col-md-6">
					<label class="col-form-label">Departure Date</label>
					<form:input type="text" class="form-control" path="flight.departureDate"/>
				</div>
				<div class="col-md-6">
					<label class="col-form-label">Departure Time</label>
					<form:input type="text" class="form-control" path="flight.departureTime"/>
				</div>
				<div class="col-md-6">
					<label class="col-form-label">Destination City</label>
					<form:input type="text" class="form-control" path="flight.toCity"/>
				</div>
				<div class="col-md-6">
					<label class="col-form-label">Destination Date</label>
					<form:input type="text" class="form-control" path="flight.destinationDate"/>
				</div>
				<div class="col-md-6">
					<label class="col-form-label">DestinationTime</label>
					<form:input type="text" class="form-control" path="flight.destinationTime"/>
				</div>
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary btn-lg">Save</button>
				</div>
			</form:form>
	<div style="clear:both;"></div>
	<div class="col-md-12 mt-2">
		<a href="${pageContext.request.contextPath}/passenger/list">Back to List</a>
	</div>
</div>
</body>

</html>










