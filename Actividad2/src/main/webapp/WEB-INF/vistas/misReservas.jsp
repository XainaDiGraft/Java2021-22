<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Mis reservas</title>
<link rel="stylesheet" type="text/css" href="/CSS/estilos.css">
</head>
<body>
	<header>
		<h2>Mis reservas</h2>
	</header>
	<nav>
		<div class="topnav">
		  <div class="borde"><a href="/inicio">Eventos</a></div>
		  <div class="borde"><a href="/eventos/listarDestacados">Destacados</a></div>
		  <div class="borde dropdown">
		  	<button class="dropbtn">Estados
      			<i class="fa fa-caret-down"></i>
   			</button>
   			<div class="dropdown-content">
		      <a href="/eventos/listarEstado/activo">Activos</a>
		      <a href="/eventos/listarEstado/cancelado">Cancelados</a>
		      <a href="/eventos/listarEstado/finalizado">Finalizados</a>
		      <a href="/inicio">Todos</a>
		    </div>
		  </div>
		  <div class="borde"><a href="/tipos/listarTipos">Tipos</a></div>
		  <c:if test="${usuarioActivo != null}">
		  	<div class="borde"><a class="active" href="/reservas/misreservas">Mis Reservas</a></div>
		  </c:if>
		  <div class="borde"><a href="/usuario/login">Login</a></div>
		  <div class="borde"><a href="/usuario/altaUsuario">Registro</a></div>
		  <c:if test="${usuarioActivo != null}">
		  	<div class="borde"><a href="/usuario/usuarioDatos">Usuario</a></div>
		  </c:if>
		  <div class="borde"><a href="/usuario/cerrarSesion">Salir</a></div>
		</div>
		<c:if test="${usuarioActivo != null}">
				<h3>Bienvenid@ ${usuarioActivo.userName}</h3>
		</c:if>
	</nav>
	<section>
		<table>
		  	<tr>
			    <th>ID</th>
			    <th>Evento</th>
			    <th>Tipo</th>
			    <th>Fecha de inicio</th>
		       	<th>Estado</th>
		       	<th>Duración</th>
			    <th>Precio de Venta</th>
			    <th>cantidad</th>
			    <th>observaciones</th>
		      	
		  	</tr>
		  	<c:forEach var="ele" items="${listaReservas}">
			  	<tr>
				    <td>${ele.idReserva}</td>
				    <td>${ele.evento.nombre}</td>
				    <td>${ele.evento.tipo.nombre}</td>
				    <td>${ele.evento.fechaInicio}</td>
				    <td>${ele.evento.estado}</td>
				    <td>${ele.evento.duracion}</td>
				    <td>${ele.precioVenta}</td>
				    <td>${ele.cantidad}</td>
				    <td>${ele.observaciones}</td>
				 </tr>
			</c:forEach>
		</table>			 
	</section>
</body>
</html>