
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
      <%@ page isELIgnored="false" %>

<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Baloo+Bhai&display=swap" rel="stylesheet">
<style>

body{
  font-family: 'Baloo Bhai', cursive;
  width:98%;
  
  background: url(https://wallpapercave.com/wp/wp2092314.jpg);
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


<sf:form action="addcategory" method="POST" modelAttribute="cat">   
<link href="https://fonts.googleapis.com/css?family=Baloo+Bhai&display=swap" rel="stylesheet">
<div id="form">


  <h1>CategoryForm</h1>

  <sf:input path="categoryName" type="text" name="user" placeholder="CategoryName"/>
  <sf:input path="categoryDescription" type="text" name="user" placeholder="CategoryDescription"/>
 <sf:input path="categoryId" type="hidden" placeholder="CategoryId"/>              
  <input type="submit" name="submit"  value="${cname}" class="submit-button"/>
</div>
</sf:form>
</body>


