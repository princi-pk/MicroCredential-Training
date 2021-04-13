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
<title>Customer Details</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet"
	href="//unpkg.com/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet"
	href="//unpkg.com/bootstrap-select@1.12.4/dist/css/bootstrap-select.min.css"
	type="text/css" />
<link rel="stylesheet"
	href="//unpkg.com/bootstrap-select-country@4.0.0/dist/css/bootstrap-select-country.min.css"
	type="text/css" />

<script src="//unpkg.com/jquery@3.4.1/dist/jquery.min.js"></script>
<script src="//unpkg.com/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script
	src="//unpkg.com/bootstrap-select@1.12.4/dist/js/bootstrap-select.min.js"></script>
<script
	src="//unpkg.com/bootstrap-select-country@4.0.0/dist/js/bootstrap-select-country.min.js"></script>

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
				<h2 id="formheading" class="card-title mb-4">Enter Your Details</h2>

				<form:form cssClass="form" id="customerDetailsForm"
					name="customerDetailsForm" modelAttribute="customerInput"
					action="/registration" method="GET">

					<div class="form-row">
						<div class="form-group col-sm-4">
							<form:label path="name">Name</form:label>
							<form:input class="form-control" type="text" path="name"
								name="name" placeholder="Enter your name"></form:input>
							<form:errors path="name"></form:errors>
							<br>
						</div>
						<div class="form-group col-sm-4">
							<form:label path="username">User Name</form:label>
							<form:input class="form-control" type="text" path="username"
								name="username" placeholder="Enter your username"></form:input>
							<form:errors path="name"></form:errors>
							<br>
						</div>
						<div class="form-group col-sm-4">
							<form:label path="password">Password</form:label>
							<form:input class="form-control" type="text" path="password"
								name="password" placeholder="Enter your password"></form:input>
							<form:errors path="password"></form:errors>
							<br>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-sm-12">
							<form:label path="address">Address</form:label>
							<form:input class="form-control" type="text" path="address"
								name="address" placeholder="Enter your address"></form:input>
							<form:errors path="address"></form:errors>
							<br>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-8 col-sm-12">
							<form:label path="country">Country</form:label>
							<form:select class="selectpicker countrypicker form-control"
								name="country" path="country">
							</form:select>
							<form:errors path="country"></form:errors>
							<br>
						</div>
						<div class="form-group col-md-4 col-sm-12">
							<form:label path="state">State</form:label>
							<form:input class="form-control" type="text" path="state"
								name="state" placeholder="Enter your state"></form:input>
							<form:errors path="state"></form:errors>
							<br>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-8 col-sm-12">
							<form:label path="email">Email</form:label>
							<form:input class="form-control" type="text" path="email"
								name="email" placeholder="Enter your email"></form:input>
							<form:errors path="email"></form:errors>
							<br>
						</div>
						<div class="form-group col-md-4 col-sm-12">
							<form:label path="dateOfBirth">Date of Birth</form:label>
							<form:input id="dateOfBirth" class="form-control"
								path="dateOfBirth" type="text" name="dateOfBirth"
								placeholder="dd-MM-yyyy"></form:input>
							<form:errors path="dateOfBirth"></form:errors>
							<br>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-sm-4">
							<form:label path="panNumber">Permanent Account Number (PAN)</form:label>
							<form:input class="form-control" type="text" path="panNumber"
								name="panNumber" placeholder="Enter your PAN number"></form:input>
							<form:errors path="panNumber"></form:errors>
							<br>
						</div>
						<div class="form-group col-sm-4">
							<form:label path="contactNumber">Contact Number</form:label>
							<form:input class="form-control" type="text" path="contactNumber"
								name="contactNumber" placeholder="Enter your Contact number"></form:input>
							<form:errors path="contactNumber"></form:errors>
							<br>
						</div>
						<div class="form-group col-sm-4">
							<form:label path="typeOfAccount">Account Type</form:label>
							<form:select class="form-control" name="typeOfAccount"
								path="typeOfAccount">
								<option>Current</option>
								<option>Savings</option>
							</form:select>
							<form:errors path="typeOfAccount"></form:errors>
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