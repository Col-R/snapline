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
<div class="container">
    <div class="row">
    	<!-- placeholder img, was thinking we could do a camera or something -->
        <img src="https://placekitten.com/1000/280" class="img-fluid" alt="login" id="banner">
    </div>

   
    <div class="row justify-content-evenly"> <!-- row 1 -->
        <div class="col-6">
         <!-- Register Form -->
            <form:form action="/registerUser" method="POST" modelAttribute="user">
                <h1 class="register_login">Register Here</h1>
                <div class="row form_style">
                    <div class="col form_windows">
                        <div class="row">
                            <div class="row">
                                <!--  	First Name on the left, last name on the right -->
                                <div class="col-6">
                                    <div class="form-group mb-3">
                                        <form:label path="firstName">First Name</form:label>
                                        <form:errors path="firstName" />
                                        <form:input class="form-control" path="firstName" />
                                    </div>
                                </div>
                                <!--  	First Name on the left, last name on the right -->
                                <div class="col-6">
                                    <div class="form-group">
                                        <form:label path="lastName">Last Name</form:label>
                                        <form:errors path="lastName" />
                                        <form:input class="form-control" path="lastName" />
                                    </div>
                                </div>
                            </div><!-- Row from line 31 end -->

                            <div class="row">
                                <div class="col-8">
                                    <div class="form-group mb-3">
                                        <form:label path="email">Email</form:label>
                                        <form:errors path="email" />
                                        <form:input class="form-control" type="email" path="email" />
                                    </div>
                                </div><!-- col from line 50 end -->
                            </div><!-- row from line 49 end -->

                            <div class="row">
                                <div class="col-8">
                                    <div class="form-group mb-3">
                                        <form:label path="username">Username</form:label>
                                        <form:errors path="username" />
                                        <form:input class="form-control" path="username" />
                                    </div>
                                </div><!-- col from line 50 end -->
                            </div><!-- row from line 49 end -->

                            <div class="row">
                                <div class="col-6">
                                    <div class="form-group mb-3">
                                        <form:label path="password">Password</form:label>
                                        <form:errors path="password" />
                                        <form:input class="form-control" type="password" path="password" />
                                    </div>
                                </div>

                                <div class="col-6">
                                    <div class="form-group mb-3">
                                        <form:label path="confirmPassword">Confirm Password</form:label>
                                        <form:errors path="confirmPassword" />
                                        <form:input class="form-control" type="password" path="confirmPassword" />
                                    </div>
                                </div>
                            </div><!-- row from line 70 end -->
                        </div><!-- row from line 30 end-->
                        <input type="submit" value="Submit" class="submitButton">
                    </div>
                </div>
            </form:form>
        </div>
        <div class = "col-6">
        <!-- login form -->
        <form action="/login" method = "POST">
        <h1 class = "register_login">Login</h1>
        <div class = "row form_style"> <!-- row A -->
        	<div class = "col form_windows">
        		<div class = "row">
        			<div class = "row"> <!-- row B -->
        				<div class = "col-8">
        					<div class = "form-group mb-3">			
								<span>${loginError }</span>
								<label for "email">Email Address</label>
								<input type = "email" name ="lemail" class= "form-control">
        					</div>
        					<div class = "form-group mb-3">	
								<label for "email">Password</label>
								<input type = "password" name ="lpassword" class= "form-control">
        					</div>
        					<input type="submit" value="Submit" class="submitButton">
        				</div>
        			</div> <!-- row B end -->
        		</div>
        		
        	</div>
        </div> <!-- end row A -->
        
   
        
        </div>
    </div> <!-- end row 1 -->
</div>



</body>
</html>