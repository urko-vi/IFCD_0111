<%@page import="com.ipartek.formacion.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
		<input type="submit" class="login login-submit" value="Enviar">
	</form>
	<div class="login-help">
    	<a href="#">Register</a>  <a href="#">Forgot Password</a>
  	</div>
  </div>
    <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>
</body>
</html>