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
				<label for="idcus">Customer</label>
				<input type="text" name="idcus" placeholder="${customername}" disabled/>
				<label for="fechainit">Fecha Inicio</label> <br>
				<input type="date" name="fechainit" placeholder="Fecha de Inicio"/> <br>
				<label for="fechafin">Fecha expiracion</label> <br>
				<input type="date" name="fechafin" placeholder="Fecha de Expiración"> <br>
				<label for="price">Precio</label> <br>
				<input type="number" name="price" placeholder="Precio"> <br>
				<input type="submit" value="Añadir">
			</form>
		</div>
	</div>
</body>
</html>