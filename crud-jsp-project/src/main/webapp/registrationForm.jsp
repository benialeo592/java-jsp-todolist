<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<div align="center">
		<h1>Register</h1>
	<form action="RegisterServlet" method="post">
	<table style="with 80%">
		<tr>
			<td>Firstname</td>
			<td><input type="text" name="firstname" required /></td>
		</tr>
		<tr>
			<td>Surname</td>
			<td><input type="text" name="surname" required /></td>
		</tr>
		<tr>
			<td>Username</td>
			<td><input type="text" name="username" required /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password1" required/></td>
		</tr>
		<tr>
			<td>Repeat Password</td>
			<td><input type="password" name="password2" required/></td>
		</tr>
	</table>
		<input type="submit" value="Register" /></input>
	</form>
		<br>
	</div>
	<jsp:include page="jsp/footer.jsp" />  
</body>
</html>