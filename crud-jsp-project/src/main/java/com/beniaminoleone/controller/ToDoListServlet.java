package com.beniaminoleone.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beniaminoleone.dao.NoteDao;
import com.beniaminoleone.model.Note;
import com.beniaminoleone.util.DBconnection;


public class ToDoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		request.getSession().setAttribute("user", username);
		request.getRequestDispatcher("detailsView.jsp").forward(request, response);
		
		
	}

}
