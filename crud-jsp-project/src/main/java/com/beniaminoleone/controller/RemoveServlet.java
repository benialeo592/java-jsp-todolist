package com.beniaminoleone.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beniaminoleone.service.UserService;
import com.beniaminoleone.util.DBconnection;


public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String privileges = request.getParameter("privileges");
		int idn = Integer.parseInt(id);
		UserService.uDao.deleteUserById(idn, privileges, DBconnection.connecToDB());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}



}
