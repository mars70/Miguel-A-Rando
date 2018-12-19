<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html">
<html>
	<head>		  	
		<title><spring:message code="app.name" /></title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel='icon' href='../images/note.ico' type='image/x-icon' sizes="16x16" />
		<spring:url value="../css/estilo.css" var="mainCss" />
		<spring:url value="../js/script.js" var="mainJs" />
		<link href="${mainCss}" rel="stylesheet" />
		<script src="${mainJs}"></script> 
	</head>
	
	<body>
		<div class="centrar">
			<h3><spring:message code="index.encabezado" /></h3>
			<div class="espaciar">
				<form:form method="POST" action="login">
					<div class="espaciar"><spring:message code="login.user" /></div>
					<div class="espaciar"><input type="text" name="user" onclick="onClickIndex()" /></div>
					<div class="espaciar"><spring:message code="login.pass" /></div>
					<div class="espaciar"><input type="password" name="pass" onclick="onClickIndex()" /></div>	
					<input type="submit" id="indexenviar" value="<spring:message code="login.login" />" />
				</form:form>	
			</div>	
			<p id="indexmensaje">${msg}</p>
			<a href="registrar"><spring:message code="login.registrar"/></a>
		</div>	
	</body>
</html>