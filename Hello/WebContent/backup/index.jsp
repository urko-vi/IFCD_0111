<%@page import="com.ipartek.formacion.bean.Alumno"%>
<%@page import="java.util.List"%>
<%@page import="com.ipartek.formacion.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestor de Alummnos</title>
</head>
<body>
	<%List<Alumno> alumnos = (List<Alumno>)request.getAttribute(Constantes.ATT_LISTADO_ALUMNOS); 
	if(alumnos != null){
		
	}
	
	
	
	%>
	

</body>
</html>