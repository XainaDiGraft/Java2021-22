<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta Usuario</title>
</head>
<body>
<h4>Mensaje:${mensajeError}</h4>
 <form action="/usuario/altaUsuario" method="post">
 	<label for="userName">Nick:</label><input type="text" id="userName" name="userName" required>
	<label for="password">Contraseña:</label><input type="password" id="password" name="password" required>
 	<label for="email">Mail:</label><input type="email" id="email" name="email" required>
 	<label for="nombre">Nombre:</label><input type="text" id="nombre" name="nombre" required>
 	<label for="direccion">Dirección:</label><input type="text" id="direccion" name="direccion" required>
 	<label for="enabledTrue">Habilitado:</label><input type="radio" id="enabledTrue" name="enabled" value="1">
 	<label for="enabledFalse">Deshabilitado:</label><input type="radio" id="enabledFalse" name="enabled" value="0">
	<input type="submit" value="Aceptar">
 </form>
</body>
</html>