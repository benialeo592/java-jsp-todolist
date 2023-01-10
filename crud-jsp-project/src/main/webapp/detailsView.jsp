<%@page import="com.beniaminoleone.util.DBconnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.beniaminoleone.model.Note"%>
<%@page import="com.beniaminoleone.dao.NoteDao"%>
<%@page import="java.util.List"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>

<a href="index.jsp">Torna Indetro</a>
<%String username = request.getSession().getAttribute("user").toString();%>	
<%List<Note> notes = NoteDao.getAllUserNotes(DBconnection.connecToDB(), username);%>	

<table id="table">
		<tr>
			<th>ID</th>
			<th>Note</th>
			<th>Delete</th>
		</tr>
		<%for(Note n : notes){%>
			<tr>
				<td><%=n.getId()%></td>
				<td><%=n.getStr()%></td>
				<td><a href="RemoveNoteServlet?id=<%=n.getId()%>"><button>Delete</button></a></td>
			</tr>
		<%}%>
			
			
	</table>
	
		<div align="center">
		<h1>AddNote</h1>
	<form action="AddNoteServlet" method="post">
	<table style="with 80%">
		<tr>
			<td>Text</td>
			<td><input type="text" name="text" required /></td>
			<td><input type="hidden" name="username" value="<%=username%>"/></td>
		</tr>
		
	</table>
		<input type="submit" value="AddNote" /></input>
	</form>
		<br>
	</div>

</body>
</html>