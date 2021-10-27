<%@page import="modelo.beans.Evento"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/estilos.css">
<title>Eventos</title>
</head>
<body>
<!-- Recuperamos la lista de eventos -->
	<%List<Evento>lista=(List<Evento>)request.getSession().getAttribute("listaEventos"); %>
<!-- Menu de navegacion -->
	<nav>
		<div class="topnav">
		  <div class="borde"><a href="#">Tipos</a></div>
		  <div class="borde"><a href="#">Eventos</a></div>
		  <div class="borde"><a href="#">Ususarios</a></div>	
		  <div class="borde"><a class="active" href="index.jsp">Eventos/Tipo</a></div>
		  <div class="borde"><a href="#">Login</a></div>
		  <div class="borde"><a href="#">Registro</a></div>
		  <div class="borde"><a href="#">Salir</a></div>
		</div>
	</nav>
		<br>
<!--Zona principal de la pagina -->
	<section>
		<!-- Titulo de la seccion -->
		<h2 class="titulo">Listado de Eventos Activos</h2>
			<br>
		<!-- Acceso a formulario de Nuevo Evento -->
		<div class="topnav" ><a href="altaEvento.jsp">Nuevo Evento</a>
		</div>
		<br>
		<!--Tabla con la lista de datos de los eventos recuperados-->
		<table class="listado">
			<tr class="cabecera">
				<th>Id</th><th>Nombre</th><th>Precio</th><th COLSPAN=3>Opciones</th>
			</tr>
		 	<!-- java -->
		 	<!-- Recorremos la lista de eventos y mostramos los que estan en estado activo -->
				<%for(Evento ele: lista){ %>
				  <%if(ele.getEstado().equals("activo")){%>
						<tr class="cuerpo">						
								<td class="ele"><%=ele.getIdEvento()%></td>
								<td class="ele"><%=ele.getTipo().getNombre() %></td>
								<td class="ele"><%=ele.getPrecio()%></td>						
								<td class="editar"><a href="eventos?opcion=editar&id=<%=ele.getIdEvento()%>">Editar</a></td>
								<td class="eliminar"><a href="eventos?opcion=eliminar&id=<%=ele.getIdEvento()%>">Eliminar</a></td>
								<td class="cancelar"><a href="eventos?opcion=cancelar&id=<%=ele.getIdEvento()%>">Cancelar</a></td>
							
						</tr>
					<%} %>
				<%} %>

				
				
		</table>
	</section>
</body>
</html>