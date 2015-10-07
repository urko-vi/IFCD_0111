<%@page import="com.ipartek.formacion.bean.Curso"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    		
	<p><a class="btn btn-primary" href="<%=Constantes.JSP_BACK_CURSO_FORM%>" title="crear nuevo curso">cree un nuevo curso</a></p>
	<%
		List<Curso> cursos = (List<Curso>)request.getAttribute(Constantes.ATT_LISTADO_ALUMNOS);
		if (cursos == null){
 
				out.print("<h2>No existe ningun curso, por favor cree alguno</h2>");				

		}else{
			%>
			<table id="tabla" cellspacing="0" width="100%">
		        <thead>
		            <tr>
		                <th>Nombre</th>
		                <th>Precio</th>
		                <th><!-- Operacion para Borrar Eliminar --></th>                
		            </tr>
		        </thead>
		 
		        <tbody>
			<% 
			Curso curso = null;
			for ( int i=0; i < cursos.size(); i++){
				curso = cursos.get(i); //detalle persona								
				%>
					<tr>
		                <td>
		                
		                		<%=curso.getNombre()%>

		                </td>
		                <td><%=curso.getPrecio()%> </td>
		                <td>
		                	<a href="<%=Constantes.SERVLET_CURSOS+"?"+Constantes.PAR_CODIGO_CURSO+"="+curso.getCodigo()%>">
		                		<button type="button" class="btn btn-primary">Editar</button>
		                	</a>
		                	<form action="<%=Constantes.SERVLET_CURSOS%>" method="post">
		                		<input type="hidden" name="<%=Constantes.PAR_CODIGO_CURSO %>" value="<%=curso.getCodigo()%>">
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