<%@page import="com.ipartek.formacion.bean.Alumno"%>
<%@page import="java.util.List"%>
<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>





<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    		
	<p><a class="btn btn-primary" href="<%=Constantes.JSP_BACK_ALUMNO_FORM%>" title="crear nuevo alumno">cree una nuevo alumno</a></p>
	<%
		List<Alumno> alumnos = (List<Alumno>)request.getAttribute(Constantes.ATT_LISTADO_ALUMNOS);
		if (alumnos == null){
 
				out.print("<h2>No existe ningun alumnos, por favor</h2>");				

		}else{
			%>
			<table id="tabla" cellspacing="0" width="100%">
		        <thead>
		            <tr>
		                <th>Nombre</th>
		                <th>Apellidos</th>
		                <th><!-- Operacion para Borrar Eliminar --></th>                
		            </tr>
		        </thead>
		 
		        <tbody>
			<% 
			Alumno al = null;
			for ( int i=0; i < alumnos.size(); i++){
				al = alumnos.get(i); //detalle persona								
				%>
					<tr>
		                <td>
		                	<a href="<%=Constantes.SERVLET_ALUMNOS+"?id="+al.getCodigoAlumno()%>">
		                		<%=al.getNombre()%>
		                	</a> 
		                </td>
		                <td><%=al.getApellidos()%> </td>
		                <td>
		                	<a href="<%=Constantes.SERVLET_ALUMNOS+"?id="+al.getCodigoAlumno()%>">
		                		<button type="button" class="btn btn-primary">Editar</button>
		                	</a>
		                	<form action="<%=Constantes.SERVLET_ALUMNOS%>" method="post">
		                		<input type="hidden" name="id" value="<%=al.getCodigoAlumno()%>">
		                		<input type="hidden" name="<%=Constantes.OP_KEY%>" value="<%=Constantes.OP_DELETE%>">
		                		<input type="submit" class="btn btn-outline btn-danger btn-xs" value="Eliminar">
		                	</form>		                	
		                </td>               
		            </tr>   
					
				<%				
			}//end:For
		%>	
		 	</tbody>
    	</table>
		<% 
		}
	%>
	
	
	
                   
       
	
	
<%@include file="../includes/footer.jsp" %>   