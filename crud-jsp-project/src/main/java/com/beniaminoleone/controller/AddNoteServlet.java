package com.beniaminoleone.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beniaminoleone.service.UserService;
import com.beniaminoleone.util.DBconnection;

public class AddNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String text = request.getParameter("text");
		String username = request.getParameter("username");
		UserService.nDao.createNote(username, text, DBconnection.connecToDB());
		response.sendRedirect("detailsView.jsp");
	}

}
