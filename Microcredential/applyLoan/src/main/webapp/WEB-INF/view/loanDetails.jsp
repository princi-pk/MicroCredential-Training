<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Loan Details</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js"
	type="text/javascript"></script>
<link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css"
	rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" />
<link rel="stylesheet" href="/style/style.css">
</head>
<body class="d-flex flex-column min-vh-100 text-warning">
	<nav class="navbar navbar-expand-lg navbar-dark"> <a
		id="navheading" class="navbar-brand"> State Bank</a>


	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarNav">
		<ul id="navlink" class="navbar-nav float-right text-right ml-auto">
			<li class="nav-item"><a class="nav-link text-white"
				href="/login">Log Out</a></li>
		</ul>

	</div>
	</nav>

	<div class="container mt-4">

		<div class="card text-white">

			<div class="card-body">
				<h2 id="formheading" class="card-title mb-4">Enter Loan Details</h2>

				<form:form cssClass="form" id="loanDetailsForm"
					name="loanDetailsForm" modelAttribute="loanInput"
					action="/applyLoan" method="GET">

						<div class="form-group">
							<form:label path="loanType">Loan Type</form:label>
							<form:input class="form-control" type="text" path="loanType"
								name="loanType" placeholder="Enter the loan type"></form:input>
							<form:errors path="loanType"></form:errors>
							<br>
						</div>
					<div class="form-row">
						<div class="form-group col-sm-6">
							<form:label path="loanAmount">Loan Amount</form:label>
							<form:input class="form-control" type="text" path="loanAmount"
								name="loanAmount" placeholder="Enter the loan amount"></form:input>
							<form:errors path="loanAmount"></form:errors>
							<br>
						</div>
						<div class="form-group col-sm-6">
							<form:label path="date">Date</form:label>
							<form:input id="date" class="form-control" path="date"
								type="text" name="date" placeholder="dd-MM-yyyy"></form:input>
							<form:errors path="date"></form:errors>
							<br>
						</div>
					</div>	
					<div class="form-row">
						<div class="form-group col-sm-6">
							<form:label path="interestRate">Rate of Interest</form:label>
							<form:input class="form-control" type="text" path="interestRate"
								name="interestRate" placeholder="Enter the rate of interest"></form:input>
							<form:errors path="interestRate"></form:errors>
							<br>
						</div>
						<div class="form-group col-sm-6">
							<form:label path="duration">Duration of Loan</form:label>
							<form:input class="form-control" type="text" path="duration"
								name="duration" placeholder="Enter the duration"></form:input>
							<form:errors path="duration"></form:errors>
							<br>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-sm-12">

							<input class="btn btn-success btn-block btn-lg" type="submit"
								name="submit" value="Register Customer">
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<footer class="text-lg-start container-fluid mt-auto"> <!-- Copyright -->
	Copyright 2021 <!-- Copyright --> </footer>
</body>
<script>
	$("#dateOfBirth").datepicker({
		uiLibrary : "bootstrap4",
		format : "dd-mm-yyyy",
		maxDate : new Date(),
	});
	$('.countrypicker').countrypicker();
</script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
	integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
	crossorigin="anonymous"></script>
</html>