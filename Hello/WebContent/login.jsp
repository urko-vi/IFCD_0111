<%@page import="com.ipartek.formacion.util.Constantes"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:set var="language" value="${not empty sessionScope.idioma ? sessionScope.idioma : 'es_ES'}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.ipartek.formacion.i18n.i18nmessages" /> 
<!DOCTYPE html >
<html lang="${idioma}">
<base href="Hello">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
  <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>

    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
</head>
<body>

	<%
	String mensaje = (String)request.getAttribute("mensaje");
	if(mensaje!=null){
		out.print(mensaje);
	}
	%>
  <div class="login-card">
	<form action="<%=Constantes.SERVLET_LOGIN %>" method="post">
		<input placeholder="introduzca su nombre" type="text" name="<%=Constantes.PAR_USUARIO %>">
		<input placeholder="" type="password" name="<%=Constantes.PAR_PASSWORD %>">
		<input type="submit" class="login login-submit" value="<fmt:message key="html.boton.enviar"/>">
	</form>
	<div class="login-help">
    	<a href="#">Register</a>  <a href="#">Forgot Password</a>
  	</div>
  </div>
    <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>
</body>
</html>