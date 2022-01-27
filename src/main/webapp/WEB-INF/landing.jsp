<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/style.css">
      <!-- Fonts -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SnapLine</title>
</head>
<body>
<div class = "container">
	<div class = "row">
		<img src = "#" class = "img-fluid" alt ="login" id ="banner">
	</div>
	
	<form:form action = "/registerUser" method = "POST" modelAttribute = "user">
	<div class = "form-group">
		<form:label path = "firstName">First Name</form:label>
		<form:errors path = "firstName"/>
		<form:input class = "form-control" path = "firstName"/>
	</div>
	<div class = "form-group">
		<form:label path = "lastName">Last Name</form:label>
		<form:errors path = "lastName"/>
		<form:input class = "form-control" path = "lastName"/>
	</div>
	<div class = "form-group">
		<form:label path = "email">Email</form:label>
		<form:errors path = "email"/>
		<form:input class = "form-control" type = "email" path = "email"/>
	</div>
	<div class = "form-group">
		<form:label path = "username">Username</form:label>
		<form:errors path = "username"/>
		<form:input class = "form-control" path = "username"/>
	</div>
	<div class = "form-group">
		<form:label path = "password">Password</form:label>
		<form:errors path = "password"/>
		<form:input class = "form-control" type="password" path = "password"/>
	</div>
	<div class = "form-group">
		<form:label path = "confirmPassword">Confirm Password</form:label>
		<form:errors path = "confirmPassword"/>
		<form:input class = "form-control" type="password" path = "confirmPassword"/>
	</div>
	<input class ="btn btn-primary" type = "submit" value = "Submit"/>

</form:form>
</div>



</body>
</html>