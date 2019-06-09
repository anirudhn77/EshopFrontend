
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
<table  border="4">
<tr>
<th>
ProductId
</th>
<th>
ProductName
</th>
<th>
ProductDescrption
</th>
<th>
ProductPrice
</th>
<th>
ProductCategory
</th>
<th>
ProductSupplier
</th>
<th>
Images
</th>
<th>
Edit
</th>
<th>
Delete
</th>
</tr>
<c:forEach items="${prolist}" var="pr">
<tr>
<td>${pr.productID}</td>
<td>${pr.productName}</td>
<td>${pr.productDescription}</td>
<td>${pr.productPrice}</td>
<td>${pr.productCategory}</td>
<td>${pr.productSupplier}</td>
 <td><img src="resources/${pr.productID}.jpg" height="50" width="50" ></td>

<td><a href="ed?proid=${pr.productID}">edit</a></td>
<td><a href="delete?proid=${pr.productID}">delete</a></td>
</tr>


</c:forEach>


</table>


</body>
</html>
