
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
     <%@ page isELIgnored="false" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    


<html>
<head>

<style>

body{
  font-family: 'Baloo Bhai', cursive;
  width:98%;
  
  background: url(https://i.pinimg.com/originals/cb/8d/52/cb8d5277f8d2775e0d815a5e4fcfd3d8.jpg);
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

<sf:form action="addproduct" method="POST" modelAttribute="pro" enctype="multipart/form-data" >
<link href="https://fonts.googleapis.com/css?family=Baloo+Bhai&display=swap" rel="stylesheet">
<div id="form">
  <h1>ProductForm</h1>

  <sf:input path="productName" type="text" name="user" placeholder="productName"/>
  <sf:input path="productDescription" type="text" name="user" placeholder="productDescription"/>
  <sf:input path="productPrice" type="text" name="user" placeholder="productPrice"/>
  <br>
   
      <sf:select path="productCategory" type="text" name="user" placeholder="productCategory" >
                              <c:forEach var="cat" items="${catlist}">
          
                               <sf:option value="${cat.categoryName}">${cat.categoryName} </sf:option>
                               </c:forEach>
                               </sf:select>
                          
                            <br>
                              
                               <sf:select path="productSupplier" type="text" name="user" placeholder="productSupplier">
                              <c:forEach var="sup" items="${suplist}">
          
                               <sf:option value="${sup.supplierName}">${sup.supplierName}  </sf:option>
                               
                               </c:forEach>
                              </sf:select>
  
                            <br>
 
                                    
                           <sf:input type="file" path="proimage"/>
                          <sf:input path="productID"  type="hidden"/>
                             <input type="submit"  value="${bname}" />
  

  <!-- <input type="submit" name="submit"  value="Login" class="submit-button"/> --> 
</div>

</sf:form>
</body>













