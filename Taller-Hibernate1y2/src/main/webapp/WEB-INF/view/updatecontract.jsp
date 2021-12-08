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
</head>
<body>
	<div class="container">
		<div class="formulario">
			<form method="post">
				<label for="id">Contract ID</label> <br>
				<input type="text" name="id" placeholder="${contrato.contractID}" disabled> <br>
				<label for="fechainit">Fecha Inicio</label> <br>
				<input type="date" name="fechainit" placeholder="${contrato.fechaV}" /> <br>
				<label for="fechafin">Fecha expiracion</label> <br>
				<input type="date" name="fechafin" placeholder="${contrato.fechaC}" /> <br>
				<label for="price">Precio</label> <br>
				<input type="number" name="price" placeholder="${contrato.price}" /> <br>
				<input type="submit" value="Update">
			</form>
		</div>
	</div>
</body>
</html>