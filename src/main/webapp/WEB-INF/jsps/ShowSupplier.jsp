
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="home.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table  border="1">
<tr>
<th>
SupplierId
</th>
<th>
SupplierName
</th>
<th>
Supplierdescrption
</th>
<th>
SupplierAddress
</th>
<th>
Edit
</th>
<th>
Delete
</th>
</tr>
<c:forEach items="${suplist}" var="sa">
<tr>
<td>${sa.supplierId}</td>
<td>${sa.supplierName}</td>
<td>${sa.supplierDescription}</td>
<td>${sa.supplierAddress}</td>
<td><a href="edt?supid=${sa.supplierId}">edit</a></td>
<td><a href="dele?supid=${sa.supplierId}">delete</a></td>
</tr>


</c:forEach>


</table>


</body>
</html>
