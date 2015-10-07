
<%@page import="com.ipartek.formacion.bean.Curso"%>
<%@include file="../includes/head.jsp" %>
<%@include file="../includes/nav.jsp" %>
<%
	Curso curso = (Curso)request.getAttribute(Constantes.ATT_CURSO);
	int op = Constantes.OP_UPDATE;
	String buttonValue = "Añadir Curso";
	if(curso == null){//crear
		curso = new Curso();
		op = Constantes.OP_CREATE;
	}else{//modificar
		buttonValue = "Modificar Curso";
	}
%>    
    

<div class="col-xs-12 col-lg-6">
	<form action="<%=request.getContextPath()+"/"+Constantes.SERVLET_CURSOS%>" method="post" role="form">
	
		<div class="form-group">			
			<input type="hidden" name="id" readonly value="<%=curso.getCodigo()%>" class="form-control">
		</div>	
		
		<div class="form-group">
			<label for="">Nombre</label>	
			<input id="" type="text"    name="name" value="<%=curso.getNombre()%>" class="form-control">
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






<%@include file="../includes/footer.jsp" %>