
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
 <%@ page isELIgnored="false" %>
<html>
<head>

<style>

body{
  font-family: 'Baloo Bhai', cursive;
  width:98%;
  
  background: url(http://www.4usky.com/data/out/52/164456453-koenigsegg-agera-r-wallpapers.jpeg);
  background-size:100%;
  background-repeat:no-repeat;
}
#form{
  
  border:5px solid white;
  border-radius:5%;
  background:transparent;
  width:300px;
  text-align:center;
  margin:100px auto;
}
#form h1{
  color:white;
}

#form input{
  color:red;
  padding:1em;
  margin:5px;
  background:white;
  border:2px solid white;
  border-radius:3%;
}
#form .text{
  width:250px;
  height:2px;
}
#form .submit-button{
  background:transparent;
  margin:15px;
  color:white;
  width:40%;
  padding:5px;
  border:3px solid;
  border-radius:7%;
}


</style>

	</head>

<body>

<sf:form action="addsupplier" method="POST" modelAttribute="sup">
<link href="https://fonts.googleapis.com/css?family=Baloo+Bhai&display=swap" rel="stylesheet">
<div id="form">
  <h1>SupplierForm</h1>

 <sf:input path="supplierId" type="hidden" placeholder="SupplierId"/>              

  <sf:input path="supplierName" type="text" name="user" placeholder="SupplierName"/>
  <sf:input path="supplierDescription" type="text" name="user" placeholder="SupplierDescription"/>
  <sf:input path="supplierAddress" type="text" name="user" placeholder="SupplierAddress"/>
  

  <input type="submit" name="submit"  value="${sname}" class="submit-button"/>
</div>
</sf:form>
</body>

