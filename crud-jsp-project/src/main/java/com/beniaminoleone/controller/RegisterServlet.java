package com.beniaminoleone.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beniaminoleone.model.Privileges;
import com.beniaminoleone.model.User;
import com.beniaminoleone.service.UserService;
import com.beniaminoleone.util.DBconnection;
import com.beniaminoleone.util.Encryption;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String surname = request.getParameter("surname");
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		if(!password1.equals(password2)) {
			response.sendRedirect("index.jsp");
		}else {
		
			User u = new User();
			u.setFirstName(firstName);
			u.setSurname(surname);
			u.setUsername(username);
			u.setPassword(Encryption.encrypt(password1));
			u.setPrivileges(Privileges.USER);
			UserService.uDao.createUser(u, DBconnection.connecToDB());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
			
	}

}
