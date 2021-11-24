<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
	table {
	  font-family: arial, sans-serif;
	  border-collapse: collapse;
	  width: 100%;
	}
	
	td, th {
	  border: 1px solid #dddddd;
	  text-align: left;
	  padding: 8px;
	}
	
	tr:nth-child(even) {
	  background-color: #dddddd;
	}
	</style>
</head>
<body>
	<h1>App gestion de productos</h1>
	<h3><a href="altaEvento.jsp">Nuevo Evento</a></h3>
	<h4>Mensaje : ${requestScope.mensaje}</h4>
	<h1>Listado abreviado de Eventos - Todos</h1>
	
	
 
 

<table>
  <tr>
    <th>Id</th>
    <th>nombre</th>
    <th>precio</th>
    <th>Estado</th>
     <th>Editar</th>
      <th>Eliminar</th>
       <th>Cancelar</th>
  </tr>
  <c:forEach var="ele" items="${listaEventos }">
  <tr>
    <td>${ele.idEvento}</td>
    <td>${ele.nombre}</td>
    <td>${ele.precio}</td>
     <td>${ele.estado}</td>
    <td><a href="eventos?opcion=editar&idEvento=${ele.idEvento }">Editar</a></td>
    <td><a href="eventos?opcion=eliminar&idEvento=${ele.idEvento }">Eliminar</a></td>
    <c:choose>
    	<c:when test="${ele.estado == 'ACTIVO' }">
    		<td><a href="eventos?opcion=cancelar&idEvento=${ele.idEvento }&estado=cancelado">Cancelar</a></td>
 		</c:when>
 		
 		<c:otherwise>
 			<td><a href="eventos?opcion=cancelar&idEvento=${ele.idEvento }&estado=ACTIVO">Activar</a></td>
 		</c:otherwise>
 	</c:choose>
  </tr>
  </c:forEach>
  </table>
</body>
</html>