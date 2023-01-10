package com.beniaminoleone.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beniaminoleone.model.User;
import com.beniaminoleone.service.UserService;
import com.beniaminoleone.util.DBconnection;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(UserService.uDao.authenticate(DBconnection.connecToDB(), username, password)) {
			HttpSession session = request.getSession();
			User u = UserService.uDao.findUserByUsername(DBconnection.connecToDB(), username);
			session.setAttribute("username", u.getUsername());
			session.setAttribute("privileges", u.getPrivileges().toString());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
	
		
	}

}
