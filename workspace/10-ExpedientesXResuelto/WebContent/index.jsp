<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
      <meta http-equiv="content-type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" href="<c:url value='/css/estilos.css'/>" type="text/css" />
      <title>Bienvenido a los Expedientes X del FBI</title>
  </head>
<body>

<img src="imagenes/xfiles.jpg" align="right"/>

<div id="content">

	<h1>Página Principal</h1>
	<p>
		Cualquiera puede ver este recurso.
	</p>
	
	<p>
		<a href="<c:url value='/expedientesx/mostrar/todos'/>">
			Mostrar	expedientes
		</a>
	</p>
	<p> 
		Solo los Agentes pueden ver este recurso. Bienvenido <%= request.getUserPrincipal().getName() %> 
		<a href="<c:url value='/logout'/>">desconectar</a> 
	</p> 
	<p>
	<%= request.getUserPrincipal() %> 
	</p>
	

</div>

</body>
</html>
