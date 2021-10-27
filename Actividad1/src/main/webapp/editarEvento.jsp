<%@page import="java.text.SimpleDateFormat"%>
<%@page import="modelo.beans.Evento"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/estilos.css">
<meta charset="UTF-8">
<title>Editar Evento</title>
</head>
<body>
	<h1>Editar Evento</h1>
	<br>
	<br>
<!-- Recuperamos el evento -->
	<%Evento evento= (Evento)request.getAttribute("evento");  %>
<!-- Formateamos la fecha -->	
	<%SimpleDateFormat date1=new SimpleDateFormat("dd/MM/yyyy");
	  String fechaTexto=date1.format(evento.getFechaInicio());%>
<!-- Creamos una tabla con los datos recuperados -->
	<table class="evento">
		<tr>
			<th class="cabecera2">ID</th>
			<td class="ele2"><%=evento.getIdEvento() %></td>
		</tr>
		<tr>
			<th class="cabecera2">NOMBRE</th>
			<td class="ele2"><%=evento.getNombre()%></td>
		</tr>
		<tr>
			<th class="cabecera2">DESCRIPCION</th>
			<td class="ele2"><%=evento.getDescripcion() %></td>
		</tr>
		<tr>
			<th class="cabecera2">FECHA INICIO</th>
			<td class="ele2"><%=fechaTexto%></td>
		</tr>
		<tr>
			<th class="cabecera2">DURACION</th>
			<td class="ele2"><%=evento.getDuracion() %></td>
		</tr>
		<tr>
			<th class="cabecera2">DIRECCION</th>
			<td class="ele2"><%=evento.getDireccion() %></td>
		</tr>
		<tr>
			<th class="cabecera2">ESTADO</th>
			<td class="ele2"><%=evento.getEstado() %></td>
		</tr>
		<tr>
			<th class="cabecera2">DESTACADO</th>
			<td class="ele2"><%=evento.getDestacado() %></td>
		</tr>
		<tr>
			<th class="cabecera2">AFORO MAXIMO</th>
			<td class="ele2"><%=evento.getAforoMaximo() %></td>
		</tr>
		<tr>
			<th class="cabecera2">MINIMO DE ASISTENCIA</th>
			<td class="ele2"><%=evento.getMinimoAsistencia() %></td>
		</tr>
		<tr>
			<th class="cabecera2">PRECIO</th>
			<td class="ele2"><%=evento.getPrecio() %></td>
		</tr><tr>
			<th class="cabecera2">TIPO</th>
			<td class="ele2"><%=evento.getTipo().getNombre() %></td>
		</tr>
		</tr><tr>
			<th class="cabecera2">DESCRIPCION DE TIPO</th>
			<td class="ele2"><%=evento.getTipo().getDescripcion() %></td>
		</tr>
	</table>
	<div class="topnav" ><a href="index.jsp">Volver</a>
</body>
</html>