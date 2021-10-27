<%@page import="modelo.beans.Tipo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="CSS/estilos.css">
<title>Insert title here</title>
</head>
<body>
	<!-- Recuperamos la lista de tipos -->
	<h1 class="tituloAlta">Alta Evento</h1>
	<%List<Tipo>lista=(List<Tipo>)request.getSession().getAttribute("listaTipos"); %>
	<br>
	<br>
	<!-- Creamos formulario de alta -->
	<div class="formulario">
		<form action="eventos?opcion=alta" method="post" autocomplete="on">

			<!-- Nombre -->
			<input type="text" name="nombre" class="nombre" required="required"
				placeholder="Nombre" autofocus="autofocus">
			<!-- Fecha Inicio -->
			<label for="fechaInicio">Fecha Inicio:</label> <input type="date"
				name="fechaInicio" required="required" min="2000-01-01"
				max="2100-12-31">
			<!-- Tipo -->
			<label for="destacado">Tipo:</label>
			<!-- Cargamos la lista de tipos en un select -->
			<select name="tipo" class="tipo">
				<%for(Tipo ele: lista){ %>
				<option value="<%=ele.getIdTipo()%>"><%=ele.getNombre() %></option>
				<%} %>
			</select>
			<!-- Duración -->
			<label for="duracion">Duración(horas):</label> <input type="number"
				name="duracion" class="numero" required="required"> <br>
			<!-- Dirección -->
			<input type="text" name="direccion" class="direccion"
				required="required" placeholder="Dirección"> <br>
			<div class="padre">
				<div class="hijo">
					<!-- Aforo Máximo -->
					<label for="aforoMaximo">Aforo Máximo:</label> <input type="number"
						name="aforoMaximo" class="numero" required="required">
					<!-- Minima Asistencia -->
					<label for="minimoAsistencia">Minima Asistencia:</label> <input
						type="number" name="minimoAsistencia" class="numero"
						required="required">
					<!-- Destacado -->
					<label for="destacado">Destacado:</label> <select name="destacado"
						class="destacado" required="required" placeholder="Destacado">
						<option value="S">Si</option>
						<option value="N">No</option>
					</select>
				</div>
				<!-- estado -->
				<div class="estado">
					<fieldset>
						<legend>Estado:</legend>
						<input type="radio" name="estado" value="activo"><label
							for="activo"> Activo</label> <input type="radio" name="estado"
							value="cancelado"><label for="cancelado">
							Cancelado</label> <input type="radio" name="estado" value="finalizado"><label
							for="finalizado"> Finalizado</label>
					</fieldset>
				</div>
			</div>
			<br>
			<!-- Descripción -->
			<textarea name="descripcion" required="required"
				placeholder="Descripción"></textarea>
			<br>
			<!-- Precio -->
			<label for="precio">Precio:</label> <input type="number"
				name="precio" class="precio" required="required"
				placeholder="Precio" min=0 step=0.01> <label>Euros</label> <input
				type="submit" value="Enviar" name="enviar">



		</form>
	</div>
</body>
</html>