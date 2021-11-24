<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/CSS/estilos.css">

</head>
<body>
	<header>
		 <h1><img src="/img/61834.png"> App Gestión de Eventos</h1>
		
	</header>
	<nav>
		<div class="topnav">
		  <div class="borde"><a class="active" href="/inicio">Eventos</a></div>
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
		  <div class="borde"><a href="/tipos/listarTipos">Tipo de Evento</a></div>
		  <c:if test="${usuarioActivo != null}">
		  	<div class="borde"><a href="/reservas/misreservas">Mis Reservas</a></div>
		  </c:if>
		  <div class="borde"><a href="/usuario/login">Login</a></div>
		  <div class="borde"><a href="/usuario/altaUsuario">Registro</a></div>
		  <c:if test="${usuarioActivo != null}">
		  	<div class="borde"><a href="/usuario/usuarioDatos">Cuenta de usuario</a></div>
		  </c:if>
		  <div class="borde"><a href="/usuario/cerrarSesion">Salir</a></div>
		</div>
		<c:if test="${usuarioActivo != null}">
				<h3>Bienvenid@ ${usuarioActivo.userName}</h3>
		</c:if>
	</nav>
	<section>
	<h3><a href="/eventos/altaEventoNuevo">Nuevo Evento</a></h3>
		
		<c:if test="${mensajeAlta!= null}">
			<h4>Mensaje : ${mensajeAlta}</h4>
		</c:if>
		<h2>Listado abreviado de Eventos - Todos</h2>
		
		<table >
		  	<tr>
			    <th rowspan="2">Nombre</th>
			    <th rowspan="2">Tipo</th>
			    <th rowspan="2">Aforo</th>
			    <th rowspan="2">Fecha inicio</th>
			    <th colspan="3">Opciones</th>
			</tr>
			<tr>
			    <th>Editar</th>
			    <c:if test="${usuarioActivo== null}">
			    	<th>Eliminar</th>
		       		<th>Estado</th>
			    </c:if>
		      	
		  	</tr>
		  	<c:forEach var="ele" items="${listaEventos}">
			  	<tr>
				    <td>${ele.nombre}</td>
				    <td>${ele.tipo.nombre}</td>
				    <td>${ele.aforoMaximo}</td>
				    <td>${ele.fechaInicio}</td>
				    <td><a href="/eventos/mostrar/${ele.idEvento}">Detalle</a></td>
				    <c:if test="${usuarioActivo== null}">
					    <td><a href="/eventos/eliminar/${ele.idEvento}">Eliminar</a></td>
					    <c:choose>
					    	<c:when test="${ele.estado == 'activo'}">
					    		<td><a href="/eventos/cambioEstado/${ele.idEvento }/cancelado">Cancelar</a>
					    		<hr><a href="/eventos/cambioEstado/${ele.idEvento }/finalizado">Finalizar</a></td>
					 		</c:when>
					 		<c:when test="${ele.estado == 'cancelado'}">
					 			<td><a href="/eventos/cambioEstado/${ele.idEvento }/activo">Activar</a>
					 			<hr><a href="/eventos/cambioEstado/${ele.idEvento }/finalizado">Finalizar</a></td>
					 		</c:when>
					 		<c:otherwise>
					 			<td><a href="/eventos/cambioEstado/${ele.idEvento }/activo">Activar</a>
					 			<hr><a href="/eventos/cambioEstado/${ele.idEvento }/cancelado">Cancelar</a></td>
					 		</c:otherwise>
					 	</c:choose>
				 	</c:if>
			  	</tr>
		  	</c:forEach>
		 </table>
	  </section>
</body>
</html>