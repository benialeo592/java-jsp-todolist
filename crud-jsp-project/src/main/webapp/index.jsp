<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.beniaminoleone.model.User"%>
<%@page import="com.beniaminoleone.dao.UserDao"%>
<%@page import="com.beniaminoleone.service.UserService"%>
<%@page import=" com.beniaminoleone.util.DBconnection"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/styles.css">
<title>index</title>
</head>
<body>
	<jsp:include page="jsp/navbar.jsp" />  
<%List<User> list = UserDao.getAll(DBconnection.connecToDB());%>		
	<table id="table">
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Surname</th>
			<th>Username</th>
			<th>Privileges</th>
			<th>Delete</th>
		</tr>
			<%for(User u : list){%>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getFirstName()%></td>
				<td><%=u.getSurname()%></td>
				<%if(request.getSession().getAttribute("username") != null && request.getSession().getAttribute("username").equals(u.getUsername()) || request.getSession().getAttribute("privileges") == "ADMIN" ){%><td><a href="ToDoListServlet?username=<%=u.getUsername()%>"><%=u.getUsername()%></a></td><%}else{%><td><%=u.getUsername()%></td><%}%>
				<td><%=u.getPrivileges()%></td>
				<%if(request.getSession().getAttribute("username") != null && request.getSession().getAttribute("privileges") == "ADMIN"){%><td><a href="RemoveServlet?id=<%=u.getId()%>&privileges=<%=u.getPrivileges()%>"><button>Delete</button></a></td><%}%>
			</tr>	
			<%}%>	
	</table>
</body>
<script>
</script>
</html>