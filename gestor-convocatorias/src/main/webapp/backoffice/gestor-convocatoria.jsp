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
List<Convocatoria> listaConv = (List<Convocatoria> )request.getAttribute("listaConvocatorias");

for(Convocatoria conv: listaConv){
  out.println(conv.getCodigo()+" - "+ conv.getNombre() +" - "+ conv.getDescripcion()+"\n");
}
List<Curso> listaCur = (List<Curso>)request.getAttribute("listaCursos");

for(Curso cur: listaCur){
  out.println(cur.getCodigo()+" - "+ cur.getNombre() +" - "+ cur.getDescripcion()+"\n");
}
%>
<a href="controller.do?candidato=crear">Crear Candidato</a>



















</body>
</html>