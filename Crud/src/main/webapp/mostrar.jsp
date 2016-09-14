<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>

<h1>Lista de Usuarios</h1>

<table border="1">

<thead>
<tr>
<td>ID</td>
<td>NOMBRE</td>
<td>APELLIDO PATERNO</td>
<td>EDAD</td>
</tr>
</thead>



<tbody>

<c:forEach var="us" items="${usuarios}" >
<tr>
<td><c:out value="${us.getId() }"></c:out></td>

<td> <c:out value="${us.getNombre() }"></c:out> </td>

<td><c:out value="${us.getApp() }"></c:out>  </td>

<td><c:out value="${us.getEdad() }"></c:out> </td>

<td> <a href="Eliminar?id= ${us.getId() }">ELIMINAR</a> </td>

<td> <a href="Update?id= ${us.getId() }">ACTUALIZAR</a> </td>
</tr>



</c:forEach>

</tbody>



</table>

</center>

</body>
</html>