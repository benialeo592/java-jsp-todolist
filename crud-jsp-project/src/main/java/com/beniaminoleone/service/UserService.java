package com.beniaminoleone.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.beniaminoleone.dao.NoteDao;
import com.beniaminoleone.dao.UserDao;
import com.beniaminoleone.model.Privileges;
import com.beniaminoleone.model.User;
import com.beniaminoleone.util.DBconnection;

public class UserService {
	public static UserDao uDao = new UserDao();
	public static NoteDao nDao = new NoteDao();
	
	public static boolean isAdmin(User u){
		if(u.getPrivileges().equals(Privileges.ADMIN)) {
			return true;
		}
			return false;
			}
	

	
}
