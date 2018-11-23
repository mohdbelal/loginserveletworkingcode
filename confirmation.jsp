<%@page import="servelet.RegistrationForm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Please confirm if you have provided correct information.<br>
If you wish to change <a href="Register.jsp">click here to submit again</a></h2>

<%
RegistrationForm form=(RegistrationForm) session.getAttribute("formData");
%>


Name: <%= form.getName() %> <br>
Email :<%= form.getEmail() %> <br>
City : <%= form.getCity()  %> <br>
Pincode :<%=  form.getPincode() %> <br>
Username :<%= form.getUsername() %><br>
Password :<%= form.getPassword() %> <br>

<br>
<a href="Storeregistrationdetail">Click Here</a> to submit details
</body>
</html>