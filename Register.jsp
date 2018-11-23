<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
<center>
<fieldset style="background-color: cyan">

<font color="red">
	<%
		List<String> errors = (List<String>) session.getAttribute("errors");
		if(errors != null) {
			for(String error : errors) {
	%>
				<b><%= error %></b> <br/>
	<%
			}
			session.removeAttribute("errors");
		}
	%>
</font>
<form    method="post" action="processRegistration">
<h2>Registration Form</h2>
<table >

<tr><td>Name : <input type="text" name="name" /><br/>             </td></tr>
<tr><td>Email : <input type="text" name="email" /><br/>           </td></tr>
<tr><td>City : <input type="text" name="city" /><br/>             </td></tr>
<tr><td>Pincode : <input type="text" name="pincode" /><br/>       </td></tr>
<tr><td>Username : <input type="text" name="username" /><br/>     </td></tr>
<tr><td>Password : <input type="password" name="password" /><br/>      </td></tr>
<tr><td>Confirm Password : <input type="password" name="confirmPassword" /><br/><br/>      </td></tr>
<tr><td><img src="captcha.jpg" /><br/><br/>                                                </td></tr>
<tr><td>Enter the captcha text : <input type="text" name="captchaInput"><br/><br/>       </td></tr>
<tr><td><input type="submit" value="Register" />                                                   </td></tr>
</form>
</table>
</form>
</fieldset>
</center>
</head>
<body>

</body>
</html>