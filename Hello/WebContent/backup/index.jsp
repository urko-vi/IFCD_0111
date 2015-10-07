<%@page import="com.ipartek.formacion.bean.Alumno"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@include file="includes/head.jsp" %>
<%@include file="includes/nav.jsp" %>
       
<%
List<Alumno>alumnos = (List<Alumno>)request.getAttribute(Constantes.ATT_LISTADO_ALUMNOS);


if(alumnos!=null){
	
%>
<div class="row">
	<div class="col-md-12">
	<!--  NOMBRE DEL CURSO -->
		Listado de alumnos
		<table class="table table-striped">
			<thead>
			  <tr>
				<th>Código</th>
				<th>Nombre</th>
				<th>Apellido</th>
			  </tr>
			</thead>
			<tbody>
			<% 
			out.print(alumnos.size());
		for(Alumno alumno: alumnos) {
			%>
			  <tr>
				<td><%out.print(alumno.getCodigoUsuario());%></td>
				<td><%out.print(alumno.getNombre());  %></td>
				<td><% out.print(alumno.getApellidos()); %></td>
			  </tr>
		<% } %>
			</tbody>
		</table>
	</div>
</div>
<% } else{
	out.println("No se han encontrado registros");	
}

%>
          

<%@include file="includes/footer.jsp" %>   


</body>
</html>