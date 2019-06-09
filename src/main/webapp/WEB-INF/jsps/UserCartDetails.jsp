
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="UserHome.jsp"%>


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
Images
</th>
<th>
CartId
</th>
<th>
ProductName
</th>
<th>
ProductPrice
</th>
<th>
ProductSupplier
</th>
<th>
ProductQuantity
</th>
<th>
TotalPrice
</th>
<th>
UserName
</th>
<th>
Delete
</th>
</tr>
<c:forEach items="${cartlist}" var="ca">
<tr>
 <td><img src="resources/${ca.productId}.jpg" height="150" width="150" ></td>
<td>${ca.cartdId}</td>
<td>${ca.productName}</td>
<td>${ca.productprice}</td>
<td>${ca.productSupplier}</td>
<td>${ca.productQuantity}</td>
<td>${ca.totalprice}</td>
<td>${ca.userName}</td>

<td><a href="deletecart?cartid=${ca.cartdId}">delete</a></td>
</tr>



</c:forEach>
</table>





</body>
</html>
