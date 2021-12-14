<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/addcustomer.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="container">
		<form method="post">
			<div class="formulario">
				<label for="name">Name</label> <br>
				<input type="text" name="name" placeholder="Name" class="w3-input"/> <br>
				<label for="first_name">First Name</label> <br>
				<input type="text" name="first_name" placeholder="FirstName" class="w3-input" /> <br>
				<label for="last_name">Last Name</label> <br>
				<input type="text" name="last_name" placeholder="LastName" class="w3-input"/> <br>
				<label for="dni">DNI</label> <br>
				<input type="text" name="dni" placeholder="DNI" class="w3-input"/> <br>
				<input type="submit" name="enviar" value="Add customer" />
			</div>
		</form>
	</div>
</body>
</html>