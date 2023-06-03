<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
<%@ include file="header.jsp" %>  
<form name="registeration" action=register method="post">
  <label for="fname">First name:</label><br>
  <input type="text" id="fname" name="fname" required="required"><br>
  
  <label for="lname">Last name:</label><br>
  <input type="text" id="lname" name="lname" required="required"><br>
  
   <label for="uname">Choose Username:</label><br>
   <input type="text" id="uname" name="uname" required="required"><br>
  
  
   <label for="password">Choose your password:</label><br>
   <input type="password" id="password" name="password" required="required"><br>
  
  
   <label for="repeatPassword">Repeat your password:</label><br>
   <input type="password" id="repeatPassword" name="repeatPassword" required="required" ><br>
  
   <label for="address">Address:</label><br>
   <input type="text" id="address" name="address" required="required"><br>
  
  
   <label for="email">Email:</label><br>
   <input type="email" id="email" name="email" required="required"><br><br>
  
  <input type="submit" value="Register Me!!" name="Register">
</form>

</body>
</html>