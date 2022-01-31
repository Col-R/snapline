<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/feed.css"/>


    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
      <!-- Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=M+PLUS+1p&family=Montserrat&display=swap" rel="stylesheet">
<meta charset="ISO-8859-1">

<title>SnapLine</title>
</head>
<body>
    <div class="container">
        <div class="row"> <!-- row 1 navbar start-->
            <nav class="navbar topnav">
                <div class="container-fluid">
                    <div>
                        <img src="https://img.icons8.com/ios/50/000000/apple-camera.png" alt="site logo" id="logo">
                        <span id="brand" class="navbar-brand">snapline</span>
                    </div>
                    <a href="/home">Home</a>
                    <a href="/home/new">Upload a Snap</a>
                    <a href="/edit/${user.id}">Edit Profile</a>
                    <a href="/logout">Log Out</a>
                </div>
            </nav>
        </div> <!-- end row 1 navbar end-->
        <div class="row">
        
            <form:form method="POST" action="/edit/${user.id}" modelAttribute="user">
                <div class="col-6">
                    <div class="form-group mb-3">
                        <form:label path="firstName">First Name</form:label>
                        <form:errors path="firstName" />
                        <form:input class="form-control" path="firstName" />
                    </div>
                </div>

                <div class="col-6">
                    <div class="form-group">
                        <form:label path="lastName">Last Name</form:label>
                        <form:errors path="lastName" />
                        <form:input class="form-control" path="lastName" />
                    </div>
                </div>


                <div class="col-8">
                    <div class="form-group mb-3">
                        <form:label path="username">Username</form:label>
                        <form:errors path="username" />
                        <form:input class="form-control" path="username" />
                    </div>
                </div><!-- col from line 50 end -->

<input type="submit" value="Save Changes" class="submitButton">
            </form:form>
        </div>
    </div>
</body>
</html>
