<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div align="center">
		<h1>Login</h1>
	<form action="LoginServlet" method="post">
	<table style="with 80%">
		<tr>
			<td>Username</td>
			<td><input type="text" name="username" required /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password" required/></td>
		</tr>
	</table>
		<input type="submit" value="Login" /></input>
	</form>
		<br>
	</div>
	<jsp:include page="jsp/footer.jsp" />  
</body>
</html>