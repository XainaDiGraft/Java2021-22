<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/CSS/estilos.css">
<title>Crear Nuevo Evento</title>
</head>
<body>
<form action="/eventos/altaEventoNuevo" method="post">

	<!-- Nombre -->
	<input type="text" name="nombre" class="nombre" required="required" placeholder="Nombre" autofocus="autofocus">
	<!-- Fecha Inicio -->
	<label for="fechaInicio">Fecha Inicio:</label> <input type="date" name="fechaInicio" required="required" >
	<!-- Tipo -->
	<label for="tipo">Tipo:</label>
	<!-- Cargamos la lista de tipos en un select -->
	<select name="tipo.idTipo" class="tipo">
		<c:forEach var="ele" items="${listaTipos}">
			<option value="${ele.idTipo}"> ${ele.nombre}</option>
		</c:forEach>
	</select>
	<!-- Duración -->
	<label for="duracion">Duración(horas):</label> <input type="number" name="duracion" class="numero" required="required"> 
	<br>
	<!-- Dirección -->
	<input type="text" name="direccion" class="direccion" required="required" placeholder="Dirección"> <br>
	<div class="padre">
		<div class="hijo">
			<!-- Aforo Máximo -->
			<label for="aforoMaximo">Aforo Máximo:</label> <input type="number"
				name="aforoMaximo" class="numero" required="required">
			<!-- Minima Asistencia -->
			<label for="minimoAsistencia">Minima Asistencia:</label> <input
				type="number" name="minimoAsistencia" class="numero"
				required="required">
			<!-- Destacado -->
			<input type="hidden" name="destacado" value="S">
			<!-- estado -->
			<input type="hidden" name="estado" value="activo">
		</div>
	</div>
	<br>
	<!-- Descripción -->
	<textarea name="descripcion" placeholder="Descripción"></textarea>
	<br>
	<!-- Precio -->
	<label for="precio">Precio:</label> <input type="number" name="precio" class="precio" required="required"
		placeholder="Precio" min=0 step=0.01> <label>Euros</label>
			
	<input type="submit" value="Enviar">
	</form>
</body>
</html>