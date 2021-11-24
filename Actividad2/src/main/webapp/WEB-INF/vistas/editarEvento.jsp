<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/CSS/estilos.css">
<meta charset="ISO-8859-1">
<title>Datos del Evento</title>
</head>
<body>
	
	<header>
		<h2>Datos del Evento</h2>
		<c:if test="${usuarioActivo != null}">
				<h3>Bienvenid@ ${usuarioActivo.userName}</h3>
		</c:if>
	</header>
	<br>
	<br>
	<div>
		<c:if test="${mensajeError!= null}">
			<h3>Error: ${mensajeError}</h3>
		</c:if>
<!-- Creamos una tabla con los datos recuperados -->
		<table class="evento">
			<tr>
				<th class="cabecera2">TIPO</th>
				<td class="ele2">${evento.tipo.nombre}</td>
			</tr>
			<tr>
				<th class="cabecera2">NOMBRE</th>
				<td class="ele2">${evento.nombre}</td>
			</tr>
			<tr>
				<th class="cabecera2">DESCRIPCION</th>
				<td class="ele2">${evento.descripcion}</td>
			</tr>
			<tr>
				<th class="cabecera2">DIRECCION</th>
				<td class="ele2">${evento.direccion}</td>
			</tr>
			<tr>
				<th class="cabecera2">FECHA INICIO</th>
				<td class="ele2">${evento.fechaInicio}</td>
			</tr>
			<tr>
				<th class="cabecera2">DURACION</th>
				<td class="ele2">${evento.duracion}</td>
			</tr>
			<tr>
				<th class="cabecera2">AFORO MAXIMO</th>
				<td class="ele2">${evento.aforoMaximo}</td>
			</tr>
			<tr>
				<th class="cabecera2">MINIMA ASISTENCIA</th>
				<td class="ele2">${evento.minimoAsistencia}</td>
			</tr>
			<tr>
				<th class="cabecera2">PRECIO</th>
				<td class="ele2">${evento.precio}</td>
			</tr>
			<tr>
				<td class="ele2">Quedan: ${plazasLib} plazas</td>
			</tr>
			
		</table>
		<form action="/reservas/altaReserva" method="post">
				
			Cuantas plazas:	<input type="number" name="cantidad" class="numero" min="0" max="10" required="required">
			<input type="hidden" name="idEvento" value="${evento.idEvento}">
			<input type="submit" value="Reservar">
				
		</form>
		<c:choose>
			<c:when test="${evento.tipo.idTipo == '1'}">
				<img alt="Concierto" src="/img/concierto.png">
			</c:when>
			<c:when test="${evento.tipo.idTipo == '2'}">
				<img alt="Despedida de Soltero" src="/img/DespedidaSoltero.png">
			</c:when>
			<c:when test="${evento.tipo.idTipo == '3'}">
				<img alt="Cumpleaños" src="/img/cumpleaños.png">
			</c:when>
			<c:when test="${evento.tipo.idTipo == '4'}">
				<img alt="Boda" src="/img/boda.png">
			</c:when>
			<c:when test="${evento.tipo.idTipo == '5'}">
				<img alt="Comunion" src="/img/comunion.png">
			</c:when>
			<c:when test="${evento.tipo.idTipo == '6'}">
				<img alt="Bautizo" src="/img/bautizo.png">
			</c:when>
		</c:choose>
	</div>
	
	<div class="topnav" ><a href="/inicio">Volver</a></div>	

</body>
</html>