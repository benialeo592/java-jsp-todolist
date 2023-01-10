<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
<%@page import="com.beniaminoleone.model.User"%>
<%if (request.getSession().getAttribute("username") == null) {%><a href="loginForm.jsp">Login</a><%}else{%>${username}<%}%>
<%if (request.getSession().getAttribute("username") == null) {%><a href="registrationForm.jsp">Registration</a><%}%>
<%if (request.getSession().getAttribute("username") != null) {%><a href="LogoutServlet">Logout</a><%}%>


