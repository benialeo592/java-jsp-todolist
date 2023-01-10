package com.beniaminoleone.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beniaminoleone.service.UserService;
import com.beniaminoleone.util.DBconnection;


public class RemoveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =  Integer.parseInt(request.getParameter("id"));
		UserService.nDao.deleteNoteById(id, DBconnection.connecToDB());
		response.sendRedirect("detailsView.jsp");
		
	}

	

}
