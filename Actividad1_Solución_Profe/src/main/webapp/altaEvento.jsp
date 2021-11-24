<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="eventos?opcion=alta" method="post">

	<input type="text" name="nombre" placeholder="nombre">
	<input type="text" name="descripcion" placeholder="descdipcion">
	<input type="date" name="fechaInicio" placeholder="fecha inicio">
	<input type="number" name="duracion" placeholder="duracion">
	<input type="text" name="direccion" placeholder="direccion">
	<input type="text" name="estado" placeholder="estado">
	<input type="text" name="destacado" placeholder="destacado">
	<input type="number" name="aforoMaximo" placeholder="aforomaximo">
	<input type="number" name="minimoAsistencia" placeholder="minimoAsistencia">
		<input type="number" name="precio" placeholder="precio">
	<input type="number" name="idTipo" placeholder="idTipo">
	<input type="submit" value="Enviar">
	</form>
</body>
</html>