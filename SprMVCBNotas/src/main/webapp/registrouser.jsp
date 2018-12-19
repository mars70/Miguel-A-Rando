<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel='icon' href='../images/note.ico' type='image/x-icon' sizes="16x16" />
		<spring:url value="../css/estilo.css" var="mainCss" />
		<spring:url value="../js/script.js" var="mainJs" />
		<link href="${mainCss}" rel="stylesheet" />
		<script src="${mainJs}"></script>

		<title><spring:message code="registrouser.title" /></title>
	</head>
	
	<body>
		<div class="centrar">
			<div id="enlinea"><h3><spring:message code="registrouser.encabezado" /></h3><span id="registrousermensaje">${msg}</span></div>
			<div class="espaciar">
				<form:form modelAttribute="usuario" action="registrar" method="POST" id="formregistrouser" >
					<form:hidden path="idUsuario" />
					
					<div class="espaciar">
						<spring:message code="registrouser.dni" />
					</div>
					<div class="espaciar">
						<form:input path="dni" maxlength="9" />
						<form:errors path="dni" cssClass="error" />
					</div>
					
					<div class="espaciar">
						<spring:message code="registrouser.nombre" />					
					</div>
					<div class="espaciar">
						<form:input path="nombre" maxlength="45" />
						<form:errors path="nombre" cssClass="error" />
					</div>
					
					<div class="espaciar">
						<spring:message code="registrouser.apellidos" />									
					</div>	
					<div class="espaciar">
						<form:input path="apellidos" maxlength="45" />
						<form:errors path="apellidos" cssClass="error" />
					</div>
					
					<div class="espaciar">
						<spring:message code="registrouser.fechanac" />					
					</div>
					<div class="espaciar">											
						<form:input type="date" path="fechaNacimiento" />
						<form:errors path="fechaNacimiento" cssClass="error" />
					</div>
							
					<div class="espaciar">
						<spring:message code="registrouser.email" />									
					</div>	
					<div class="espaciar">
						<form:input path="email" maxlength="100" />
						<form:errors path="email" cssClass="error" />
					</div>		
					
					<div class="espaciar">
						<spring:message code="registrouser.apodo" />									
					</div>	
					<div class="espaciar">
						<form:input path="apodoUsuario" maxlength="45" />
						<form:errors path="apodoUsuario" cssClass="error" />
					</div>
					
					<div class="espaciar">
						<spring:message code="registrouser.pass" />									
					</div>	
					<div class="espaciar">
						<form:input path="clave" maxlength="45" />
						<form:errors path="clave" cssClass="error" />
					</div>						
																				
					<input type="submit" id="registrouserguardar" value="<spring:message code="registrouser.guardar"/>" />
					
					<a href="index.jsp" id="dcha"><spring:message code="registrouser.cancelar"/></a>
				</form:form>				
			</div>
		</div>
	</body>
</html>