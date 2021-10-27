<%@ page import="java.util.List" %>
<%@ page import="modelo.beans.Producto" %>
<%@ page import="modelo.daos.IntProducto" %>
<%@ page import="modelo.daos.ProductoListImp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	IntProducto iprod=new ProductoListImp();
	List<Producto> lista=iprod.findAll();
	String mensaje = null;%>
	
	<h1>Bienvenido a Productos App</h1>
	<h2>Opciones Productos</h2>
	
	<p><a href="productos?opcion=novedades">Novedades</a></p>
	<p><a href="familias?opcion=todas">Familia</a></p>
	
	<h2>Listado de productos</h2>
	
		<h3>Mensajes: <%=(mensaje != null)?mensaje:"" %></h3>
		
	<h3><a href="FormAltaProducto.jsp">Nuevo Producto</a></h3>
	<table border="2">
	<tr>
		<th>Id</th><th>Descripcion</th><th>precio</th><th>familia</th><th>Editar</th><th>Eliminar</th>		
	</tr>
	<%for(Producto ele:lista){ %>
		<tr>
			<td><%=ele.getIdProducto() %></td>
			<td><%=ele.getDescripcion() %></td>
			<td><%=ele.getPrecioUnitario() %></td>
			<td><%=ele.getFamilia().getDescripcion() %></td>
			<td><a href="productos?opcion=editar&id=<%=ele.getIdProducto() %>">Editar Producto</a></td>
			<td><a href="productos?opcion=eliminar&id=<%=ele.getIdProducto() %>">Eliminar Producto</a></td>
		</tr>
	<%}%>
	</table>
</body>
</html>