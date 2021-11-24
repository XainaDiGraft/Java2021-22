<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conectar usuario</title>
</head>
<body>
	<h4>Mensaje:${mensajeError}</h4>
	<form action="/usuario/login" method="post">
		<label>Usuario:</label><input type="text" name="userName">
		<label>Contraseña:</label><input type="text" name="password">
		<input type="submit" value="Aceptar">
		
		
	</form>
	<a href="/usuario/altaUsuario">Registrar nuevo usuario</a>
</body>
</html>