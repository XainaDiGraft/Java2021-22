<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/CSS/estilos.css">
<title>Cuenta de usuario</title>
</head>
<body>
	<header>
		<h2>Cuenta de usuario</h2>
		<c:if test="${usuarioActivo != null}">
				<h3>Bienvenid@ ${usuarioActivo.userName}</h3>
		</c:if>
	</header>
	<table class="evento">
		<tr>
			<th class="cabecera2">ID</th>
			<td class="ele2">${usuario.idUsuario}</td>
		</tr>
		<tr>
			<th class="cabecera2">Nombre de usuario</th>
			<td class="ele2">${usuario.userName}</td>
		</tr>
		<tr>
			<th class="cabecera2">password</th>
			<td class="ele2">${usuario.password}</td>
		</tr>
		<tr>
			<th class="cabecera2">E-mail</th>
			<td class="ele2">${usuario.email}</td>
		</tr>
		<tr>
			<th class="cabecera2">Nombre</th>
			<td class="ele2">${usuario.nombre}</td>
		</tr>
		<tr>
			<th class="cabecera2">Dirección</th>
			<td class="ele2">${usuario.direccion}</td>
		</tr>
		<tr>
			<th class="cabecera2">Habilitado</th>
			<td class="ele2"><c:choose>
				<c:when test="${usuario.enabled}==0">Deshabilitado</c:when> 
				<c:otherwise>Habilitado</c:otherwise>
			</c:choose></td>
		</tr>
		<tr>
			<th class="cabecera2">Fecha de registro</th>
			<td class="ele2"><fmt:formatDate pattern = "dd-MM-yyyy" value = "${usuario.fechaRegistro}" /></td>
		</tr>
	</table>
	<div class="topnav"><a href="/inicio">Volver</a>
</body>
</html>