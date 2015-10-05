<%@page import="com.ipartek.formacion.util.Constantes"%>
<%@page import="com.ipartek.formacion.bean.Usuario"%>
<%@page import="java.util.Map"%>
<%@page import="com.ipartek.formacion.bean.Alumno"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.ipartek.formacion.bean.Curso"%>
<%@page import="com.ipartek.formacion.service.CursoService"%>
<%@page import="com.ipartek.formacion.bean.Vehiculo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.service.VehiculoService"%>
<%@page import="com.ipartek.formacion.AdiosMundo"%>
<%@page import="com.ipartek.formacion.HolaMundo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hola mundo</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
<%
Usuario usuario = (Usuario)session.getAttribute(Constantes.ATT_USUARIO);
%>
<!-- Comentario HMTL -->
<div class="container-fluid">
<div>
Hola!! Bienvenido <%=usuario.getUserName() %> <a href="<%=Constantes.SERVLET_LOGOUT%>">Salir[x]</a>
</div>
<div class="row">
	<div class="col-md-12">
		<table class="table table-striped">
			<thead>
			  <tr>
				<th>Código</th>
				<th>Marca</th>
				<th>Modelo</th>
			  </tr>
			</thead>
			<%
VehiculoService vs = new VehiculoService();
ArrayList<Vehiculo> listadoVehiculos = vs.getAll(); 
			%>
			<tbody>
			<% for(int i= 0; i < listadoVehiculos.size();i++) { %>
			  <tr>
			  <%Vehiculo v = listadoVehiculos.get(i); %>
				<td><%=v.getCodigo() %></td>
				<td><% out.println(v.getMarca()); %></td>
				<td><% out.println(v.getModelo()); %></td>
			  </tr>
			  <%} %>
			</tbody>
		</table>
	</div>
</div>
<!-- MOSTRAR LISTADO DE ALUMNOS DE UN CURSO POR DEFECTO -->

<%
CursoService cs =  new CursoService();
Curso curso = cs.getById(0);
%>
<div class="row">
	<div class="col-md-12">
	<!--  NOMBRE DEL CURSO -->
		<%=curso.getNombre() %>
		<table class="table table-striped">
			<thead>
			  <tr>
				<th>Código</th>
				<th>Nombre</th>
				<th>Apellido</th>
			  </tr>
			</thead>
			<%
Map<Integer,Alumno> listadoAlumnos = curso.getListadoAlumnos();
			%>
			<tbody>
			<% 
for(Map.Entry<Integer,Alumno> entry: listadoAlumnos.entrySet()){
			
			%>
			  <tr>
			  <% 			
			  Alumno alum = entry.getValue();
			  %>
				<td><%out.print(alum.getCodigoAlumno());/*.getCodigoAlumno()*/%></td>
				<td><%out.print(alum.getNombre());  %></td>
				<td><% out.print(alum.getApellidos()); %></td>
			  </tr>
			  <%} %>
			</tbody>
		</table>
	</div>
</div>
</div>
</body>
</html>