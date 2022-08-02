<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration form</title>
</head>
<body>
	<h1>Employee successfully registered!</h1>
</body>
<%
String fname=request.getParameter("firstName");
out.println("First Name: " + fname);out.println("<br>");
String lname=request.getParameter("lastName");
out.println("Last Name: " + lname);out.println("<br>");
String uname=request.getParameter("username");
out.println("Username: " + uname);out.println("<br>");
String address=request.getParameter("address");
out.println("Address: " + address);out.println("<br>");
String contact=request.getParameter("contact");
out.println("Contact: " + contact);out.println("<br>");
%>
</html>