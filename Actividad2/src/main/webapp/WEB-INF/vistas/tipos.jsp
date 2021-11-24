<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/CSS/estilos.css">
<title>Listado de Tipos</title>
</head>
<body>
	<header>
		<h2>Tipos de Eventos</h2>
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
		  <div class="borde"><a class="active" href="/tipos/listarTipos">Tipos</a></div>
		  <c:if test="${usuarioActivo != null}">
		  	<div class="borde"><a href="/reservas/misreservas">Mis Reservas</a></div>
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
	<br>
	<br>
	<section>
<!-- Creamos una tabla con los datos recuperados -->
		<table>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Descripcion</th>
			</tr>
			<c:forEach var="ele" items="${listaTipos}">
				  	<tr>
					    <td>${ele.idTipo}</td>
					    <td>${ele.nombre}</td>
					    <td>${ele.descripcion}</td>
					</tr>
			</c:forEach>
		</table>
	</section>

</body>
</html>