<%@page import="com.ipartek.formacion.bean.Alumno"%>
<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>
<%
		//recoger attributo de Alumno		
		Alumno al = (Alumno)request.getAttribute(Constantes.ATT_ALUMNO);
		//inicializar variables para el formulario		
		String buttonValue = "Modificar";
		String op = Constantes.OP_UPDATE;
		boolean isNew = false;
		
		//nueva persona				
		if ( al == null ){
			al = new Alumno();
			isNew = true;
			op = Constantes.OP_CREATE;
			buttonValue = "Crear";
		//modificar persona	
		}
		/*else{			
			buttonValue = "Modificar";
		}*/
%>    
    

<div class="col-xs-12 col-lg-6">
	<form action="<%=request.getContextPath()+"/"+Constantes.SERVLET_ALUMNOS%>" method="post" role="form">
	
		<div class="form-group">			
			<input type="hidden" name="id" readonly value="<%=al.getCodigoAlumno()%>" class="form-control">
		</div>	
		
		<div class="form-group">
			<label>Nombre</label>	
			<input type="text"    name="name" value="<%=al.getNombre()%>" class="form-control">
		</div>	
		
		<div class="form-group">			
			<label>Edad</label>

		</div>		
		<!-- 
		resto de atributos
		 -->

			
		<div class="form-group">		
			<input type="hidden" name="<%=Constantes.OP_KEY%>" value="<%=op%>" class="form-control">
		</div>		
		
		<div class="form-group">
			<input type="submit" value="<%=buttonValue%>" class="btn btn-outline btn-primary">
		</div>		
	
	</form>
</div>	

	<% //en el caso de que exista dar la opción a borrarlo 
	if ( !isNew) { %>	
		<form action="<%=request.getContextPath()+"/"+Constantes.SERVLET_ALUMNOS%>" method="post">
			<input type="hidden"  name="id"  value="<%=al.getCodigoAlumno()%>">
			<input type="hidden" name="<%=Constantes.OP_KEY%>" value="<%=Constantes.OP_DELETE%>">
			<input type="submit" value="Eliminar" class="btn btn-outline btn-danger">	
		</form>
	<% } %>	










<%@include file="../includes/footer.jsp" %>