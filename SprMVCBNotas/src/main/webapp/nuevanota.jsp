<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html">
<html>
	<head>	
		<title><spring:message code="nuevanota.title" /></title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel='icon' href='../images/note.ico' type='image/x-icon' sizes="16x16" />
		<spring:url value="../css/estilo.css" var="mainCss" />
		<spring:url value="../js/script.js" var="mainJs" />
		<link href="${mainCss}" rel="stylesheet" />
		<script src="${mainJs}"></script> 
		
		<script>	
			n =  new Date();
		//Año
			y = n.getFullYear();
		//Mes
			m = n.getMonth() + 1;
		//Día
			d = n.getDate();		
		
			function inicio(){
       			document.formnuevanota.fechaactual.value =d+"/"+m+"/"+y;
    		};
    		window.onload = inicio;
  		</script>
	</head>
	
	<body>
		<div class="centrar">
			<div id="enlinea"><h3><spring:message code="nuevanota.encabezado" /></h3><span id="nuevanotamensaje">${msg}</span></div>
			<div class="espaciar">
				<form:form modelAttribute="nota" action="guardar" method="POST" id="formnuevanota" name="formnuevanota">
					<form:hidden path="idNota" />
					
					<div class="espaciar">
						<spring:message code="nuevanota.iduser" />					
					</div>
					<div class="espaciar">
						<form:input path="usuario.idUsuario" name="iduserensesion" id="iduserensesion" readonly="true"/>
					</div>
					
					<div class="espaciar">
						<spring:message code="nuevanota.fecha" />					
					</div>
					<div class="espaciar">
						<form:input path="fechaNota" name="fechaactual" id="fechaactual" readonly="true"/>
					</div>
					
					<div class="espaciar">
						<spring:message code="nuevanota.tema" />
					</div>
					<div class="espaciar">
						<form:select path="tema.idTema" items="${lista}" itemLabel="tema" itemValue="idTema" onclick="onClickNuevaNota()" />	
					</div>
					<div class="espaciar">
						<spring:message code="nuevanota.titulo" />					
					</div>
					<div class="espaciar">
						<form:input path="titulo" maxlength="45" onclick="onClickNuevaNota()" />
					</div>
					<div class="espaciar">
						<spring:message code="nuevanota.nota" />									
					</div>	
					<div class="espaciar">
						<!-- <form:input path="nota" /> -->
						<form:textarea path="nota" rows="5" cols="30" onclick="onClickNuevaNota()" />
					</div>
					<div class="espaciar">
						<spring:message code="nuevanota.importancia" />					
					</div>
					<div class="espaciar">
						<form:input type="number" min="0" max="10" path="importancia" onclick="onClickNuevaNota()" />
					</div>
								
					<a href="menu.jsp"><spring:message code="nuevanota.cancelar"/></a>
					
					<input type="submit" id="nuevanotaguardar" value="<spring:message code="nuevanota.guardar"/>" />
				</form:form>				
			</div>
		</div>
	</body>
</html>