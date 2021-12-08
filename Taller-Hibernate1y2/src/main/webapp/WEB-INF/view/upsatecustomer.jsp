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
<link rel="stylesheet" href="css/updatecustomer.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="container">
		<div><a href="Main">salir</a></div>
		<form method="post">
			<div class="formulario">
				<label for="name">Name</label> <br>
				<input type="text" name="name" placeholder="${cstomer.name}" class="w3-input"/> <br>
				<label for="dni">DNI</label> <br>
				<input type="text" name="dni" placeholder="${cstomer.dni}" class="w3-input"/> <br>
				<label for="first_name">First Name</label> <br>
				<input type="text" name="first_name" placeholder="${cstomer.lastName}" class="w3-input" /> <br>
				<label for="last_name">Last Name</label> <br>
				<input type="text" name="last_name" placeholder="${cstomer.secondLastName }" class="w3-input"/> <br>
				<input type="submit" name="enviar" value="Update customer" />
			</div>
		</form>
		<div>
			<c:if test="${updated!=null}">
				<p>${updated}</p>
			</c:if>
		</div>
	</div>
</body>
</html>