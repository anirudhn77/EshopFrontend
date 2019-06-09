
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

<img alt="img" src="resources/${pr.productID}.jpg" height="50" width="50" /><br>
${pr.productName}<br>
${pr.productDescription}<br>
${pr.productPrice}<br>
${pr.productCategory}<br>
${pr.productSupplier}
<form action="addtocart"  >
<input type="hidden" value="${pr.productID}" name="p"  />
Quantity<input type="number" min="1" max="10" name="q" />
<input type="submit" value="AddToCart">
</form>


<a href="#"> BuyNow</a>









</body>
</html>
