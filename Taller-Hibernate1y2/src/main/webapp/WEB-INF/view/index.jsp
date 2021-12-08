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
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<div class="container">
		<h1>Tabla de Clientes</h1>
		<div class="add"><a href="AddCustomer"><i class="fas fa-plus"></i>add customer</a></div>
		<table>
			<thead>
				<tr>
					<th><fmt:message key="id" /></th>
					<th><fmt:message key="name" /></th>
					<th><fmt:message key="first_name" /></th>
					<th><fmt:message key="last_name" /></th>
					<th><fmt:message key="dni" /></th>
					<th>Contrato</th>
					<th>Edit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customers}" var="customer">
					<tr>
						<td>${customer.customerID}</td>
						<td>${customer.name}</td>
						<td>${customer.lastName}</td>
						<td>${customer.secondLastName}</td>
						<td>${customer.dni}</td>
						<td>
							<a href="Contract?cid=${customer.customerID}"><i class="fas fa-file-contract"></i></a>
						</td>
						<td class="edl">
							<a href="UpdateCustomer?customerid=${customer.customerID}"><i class="fas fa-edit"></i></a>
							<a href="DeleteCustomer?customerid=${customer.customerID}"><i class="fas fa-trash-alt"></i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>