<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>

<h1>Actualizar los Usuarios </h1>


<jsp:useBean id="usuario" class="com.crud.dao.Usuarios" scope="request"></jsp:useBean>
<form action="Update" method="post">



<table>

<tr>
<td>ID:</td>
<td><input type="hidden" name="id" value="<%=usuario.getId()%>"/></td>
</tr>

<tr>
<td>NOMBRE:</td>
<td><input type="text" name="nombre" value="<%=usuario.getNombre()%>"/></td>
</tr>

<tr>
<td>APELLIDO PATERNO:</td>
<td><input type="text" name="app" value="<%=usuario.getApp()%>"/></td>
</tr>

<tr>
<td>EDAD:</td>
<td><input type="text" name="edad" value="<%=usuario.getEdad()%>"/></td>
</tr>

<tr>

<td><input type="submit" value="ACTUALIZAR USUARIOS"/></td>
</tr>
</table>

<a href="index.jsp">INICIO</a>
</center>

</body>
</html>