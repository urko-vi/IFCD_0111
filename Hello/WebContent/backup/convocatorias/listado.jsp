<%@page import="com.ipartek.formacion.bean.Convocatoria"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    		
	<p><a class="btn btn-primary" href="<%=Constantes.JSP_BACK_CURSO_FORM%>" title="crear nuevo curso">cree un nuevo curso</a></p>
	<%
		List<Convocatoria> convocatorias = (List<Convocatoria>)request.getAttribute(Constantes.ATT_LISTADO_CONVOCATORIAS);
		if (convocatorias == null){
 
				out.print("<h2>No existe ningun curso, por favor cree alguno</h2>");				

		}else{
			%>
			<table id="tabla">
		        <thead>
		            <tr>
		                <th>Nombre</th>
		                <th><!-- Operacion para Borrar Eliminar --></th>                
		            </tr>
		        </thead>
		 
		        <tbody>
			<% 
			Convocatoria convocatoria = null;
			for ( int i=0; i < convocatorias.size(); i++){
				convocatoria = convocatorias.get(i); //detalle persona								
				%>
					<tr>
		                <td>
		                
		                		<%=convocatoria.getNombre()%>

		                </td>
		                <td>
		                	<a href="<%=Constantes.SERVLET_CONVOCATORIAS+"?"+Constantes.PAR_CODIGO+"="+convocatoria.getCodigo()%>">
		                		<button type="button" class="btn btn-primary">Editar</button>
		                	</a>
		                	<form action="<%=Constantes.SERVLET_CURSOS%>" method="post">
		                		<input type="hidden" name="<%=Constantes.PAR_CODIGO %>" value="<%=convocatoria.getCodigo()%>">
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