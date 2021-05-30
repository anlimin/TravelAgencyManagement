<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <h2 class="text-center">Flight Information</h2>
</div>

<div class="container">
    <div class="table-responsive">
        <table class="table table-striped table-dark table-hover mt-3 text-center">
            <thead>
            <tr>
                <th scope="col">Departure City</th>
                <th scope="col">Departure Date</th>
                <th scope="col">Departure Time</th>
                <th scope="col">Destination City</th>
                <th scope="col">Destination Date</th>
                <th scope="col">Destination Time</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="tempFlight" items="${flights}">
                <tr>
                    <td> ${tempFlight.fromCity} </td>
                    <td> ${tempFlight.departureDate} </td>
                    <td> ${tempFlight.departureTime} </td>
                    <td> ${tempFlight.toCity} </td>
                    <td> ${tempFlight.destinationDate} </td>
                    <td> ${tempFlight.destinationTime} </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div style="clear:both;"></div>
    <p>
        <a href="${pageContext.request.contextPath}/passenger/list">Back to List</a>
    </p>
</div>
</body>

</html>
