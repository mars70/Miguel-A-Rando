<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html">
<html>
	<head>		
		<title><spring:message code="index.titulo"/></title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel='icon' href='../images/note.ico' type='image/x-icon' sizes="16x16" />
		<spring:url value="../css/estilo.css" var="mainCss" />
		<spring:url value="../js/script.js" var="mainJs" />
		<link href="${mainCss}" rel="stylesheet" />
		<script src="${mainJs}"></script> 
	</head>
	
	<body>
		<div class="centrar">
			<h3><spring:message code="menu.encabezado" /></h3>
			<div class="espaciar">
				<form method="GET" action="guardar">
					<input type="submit" id="menucrear" value="<spring:message code="menu.crear"/>"/>
				</form>
			</div>
			<div class="espaciar">
				<form:form modelAttribute="nota" method="POST" action="listar">	
					<fieldset>
						<legend id="menuleyend">Filtrado y/o consulta</legend>
						
							<div><label id='tema' for='temas'>Tema</label></div>						
							<div><select size="4" id='temas' class="filtro" ></select></div> 
							 
							<div><label id='titulo' for='titulos'>Título</label></div>
							<div><select size="4" id='titulos' class="filtro" ></select></div>
							 
							<div><label id='valor' for='valores'>Valor</label> </div>
							<div><select size="4" id='valores' class="filtro" ></select></div> 
													
							<div><input type="submit" id="menuconsultar" value="<spring:message code="menu.consultar"/>"/></div>
							
					</fieldset>
				</form:form>
			</div>
			<a href="logout" id="fdcha"><spring:message code="menu.salir"/></a>
		</div>
	</body>
</html>