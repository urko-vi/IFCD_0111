<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.ipartek.formacion.pojo.Curso"%>
<%@page import="com.ipartek.formacion.pojo.Convocatoria"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
List<Convocatoria> listaConv = (List<Convocatoria> )request.getAttribute("datos");
if(listaConv!=null){
	for(Convocatoria conv: listaConv){
	  out.println(conv.getCodigo()+" - "+ conv.getNombre() +" - "+ conv.getDescripcion()+"\n");
	}
}
%>
<table>
	<thead>
	 	<tr>
      		<th>codigo</th>
      		<th>nombre</th>
      		<th>descripcion</th>
       	</tr>
	</thead>
	<tbody>
	<c:forEach items="${datos}" var="conv">
		<tr>
	    	<td>${conv.codigo}</td>
	    	<td>${conv.nombre}</td>
	    	<td>${conv.descripcion}</td>
	    </tr>
	</c:forEach>
	</tbody>
</table>


















</body>
</html>