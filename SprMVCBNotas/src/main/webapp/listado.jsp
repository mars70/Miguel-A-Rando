<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
 
<!DOCTYPE html>
<html>
	<head>		
		<title><spring:message code="listado.title"/></title>		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel='icon' href='../images/note.ico' type='image/x-icon' sizes="16x16" />
		<spring:url value="../css/estilo.css" var="mainCss" />
		<spring:url value="../js/script.js" var="mainJs" />
		<link href="${mainCss}" rel="stylesheet" />
		<script src="${mainJs}"></script> 
		<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="../css/bootstrap.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
	</head>

	<body>
		<div class="position-fixed" >
			<a href="menu.jsp"><spring:message code="nuevanota.cancelar"/></a>
		</div>
		
		<div class="container">
  			<div><h2>LISTA DE NOTAS</h2></div>
  			<div class="panel panel-default" id="cabecera">
    			<div class="panel-body" id="useridentidad">Usuario: ${identidad}</div>
  			</div>
		</div>
		
		<div class="container ">
					
				<table class="table table-hover">			
					<tr>
						<th><spring:message code="nota.tema"/></th>
						<th><spring:message code="nota.titulo"/></th>
						<th><spring:message code="nota.nota"/></th>
						<th><spring:message code="nota.importancia"/></th>
						<th><spring:message code="listado.actualizar"/></th>
						<th><spring:message code="listado.eliminar"/></th>						
					</tr>
					<c:forEach items="${lista}" var="item">
						<tr>
							<td>${item.tema.tema}</td>
							<td><div class="divScrollH">${item.titulo}</div></td>
							<td><div class="divScrollH">${item.nota}</div></td>	
							<td>${item.importancia}</td>
							<td><a href="actualizar?id=${item.idNota}"><spring:message code="listado.actualizar"/></a></td>		
							<td><a href="eliminar?id=${item.idNota}"><spring:message code="listado.eliminar"/></a></td>	
						</tr>
					</c:forEach>
				</table>		
			
			<div id="linklistado">
				<a href="menu.jsp"><spring:message code="nuevanota.cancelar"/></a>
			</div>
		</div>
	</body>
</html>