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

<h1>registro de usuario</h1>

<form action="RegistroServlet" method="post">
<table>

<tr>
<td>NOMBRE:</td>
<td><input type="text" name="nombre"/></td>
</tr>

<tr>
<td>APELLIDO PATERNO:</td>
<td><input type="text" name="app"/></td>
</tr>

<tr>
<td>EDAD:</td>
<td><input type="text" name="edad"/></td>
</tr>

<tr>

<td><input type="submit" value="REGISTRO DEUSUARIOS"/></td>
</tr>
</table>

</form>

</center>

</body>
</html>