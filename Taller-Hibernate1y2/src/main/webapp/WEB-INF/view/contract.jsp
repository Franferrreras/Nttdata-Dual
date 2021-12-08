<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE htsml>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/contract.css">
</head>
<body>
	<div class="container">
		<div class="newcontrato"><a href="AddContract?cid=${customer.customerID}">New Contrato</a></div>
		<div class="box">
			<h3>Cliente: ${customer.name} con DNI ${customer.dni}</h3>
		</div>
		<div class="box2">
			<form method="post">
				<label for="cntratos">Contratos</label> 
				<div class="custom-select">
					<select id="cntratos" name="cntratos">
					<c:forEach items="${contratos}" var="contrato">
						<option value="${contrato.contractID}">Fecha creación: ${contrato.fechaV}</option>
					</c:forEach>
				</select> 
				</div>
				<input type="submit" value="mostrar" />
			</form>
		</div>
		<div class="box3">
			<c:choose>
				<c:when test="${contrato != null}">
					<div class="bb3">
						<div>Contract ID: ${contrato.contractID}</div>
						<div class="edit">${contrato.fechaV}</div>
						<div>Fecha Inicio</div>
						<div class="edit">${contrato.fechaC}</div>
						<div>Fecha expiración</div>
						<div class="edit">${contrato.price}</div>
						<div>Precio</div>
					</div>
					<div><a href="UpdateContract?contrid=${contrato.contractID}">Edit contract</a></div>
					<div><a href="DeleteContract?contraid=${contrato.contractID}">Eliminar</a></div>
					<%-- <table>
						<thead>
							<tr>
								<th>Contract ID</th>
								<th>Fecha Validacion</th>
								<th>Fecha Caducidad</th>
								<th>Precio</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${contrato.contractID}</td>
								<td>${contrato.fechaV}</td>
								<td>${contrato.fechaC}</td>
								<td>${contrato.price}</td>
							</tr>
						</tbody>
					</table> --%>
				</c:when>
			</c:choose>
		</div>
	</div>
</body>
<script>
var x, i, j, l, ll, selElmnt, a, b, c;
/*look for any elements with the class "custom-select":*/
x = document.getElementsByClassName("custom-select");
l = x.length;
for (i = 0; i < l; i++) {
  selElmnt = x[i].getElementsByTagName("select")[0];
  ll = selElmnt.length;
  /*for each element, create a new DIV that will act as the selected item:*/
  a = document.createElement("DIV");
  a.setAttribute("class", "select-selected");
  a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
  x[i].appendChild(a);
  /*for each element, create a new DIV that will contain the option list:*/
  b = document.createElement("DIV");
  b.setAttribute("class", "select-items select-hide");
  for (j = 1; j < ll; j++) {
    /*for each option in the original select element,
    create a new DIV that will act as an option item:*/
    c = document.createElement("DIV");
    c.innerHTML = selElmnt.options[j].innerHTML;
    c.addEventListener("click", function(e) {
        /*when an item is clicked, update the original select box,
        and the selected item:*/
        var y, i, k, s, h, sl, yl;
        s = this.parentNode.parentNode.getElementsByTagName("select")[0];
        sl = s.length;
        h = this.parentNode.previousSibling;
        for (i = 0; i < sl; i++) {
          if (s.options[i].innerHTML == this.innerHTML) {
            s.selectedIndex = i;
            h.innerHTML = this.innerHTML;
            y = this.parentNode.getElementsByClassName("same-as-selected");
            yl = y.length;
            for (k = 0; k < yl; k++) {
              y[k].removeAttribute("class");
            }
            this.setAttribute("class", "same-as-selected");
            break;
          }
        }
        h.click();
    });
    b.appendChild(c);
  }
  x[i].appendChild(b);
  a.addEventListener("click", function(e) {
      /*when the select box is clicked, close any other select boxes,
      and open/close the current select box:*/
      e.stopPropagation();
      closeAllSelect(this);
      this.nextSibling.classList.toggle("select-hide");
      this.classList.toggle("select-arrow-active");
    });
}
function closeAllSelect(elmnt) {
  /*a function that will close all select boxes in the document,
  except the current select box:*/
  var x, y, i, xl, yl, arrNo = [];
  x = document.getElementsByClassName("select-items");
  y = document.getElementsByClassName("select-selected");
  xl = x.length;
  yl = y.length;
  for (i = 0; i < yl; i++) {
    if (elmnt == y[i]) {
      arrNo.push(i)
    } else {
      y[i].classList.remove("select-arrow-active");
    }
  }
  for (i = 0; i < xl; i++) {
    if (arrNo.indexOf(i)) {
      x[i].classList.add("select-hide");
    }
  }
}
/*if the user clicks anywhere outside the select box,
then close all select boxes:*/
document.addEventListener("click", closeAllSelect);
</script>

</html>