package com.beniaminoleone.service;

import java.sql.Connection;
import java.sql.SQLException;
import com.beniaminoleone.dao.UserDao;
import com.beniaminoleone.model.Privileges;
import com.beniaminoleone.model.User;
import com.beniaminoleone.util.DBconnection;

public class UserService {
	static public UserDao uDao = new UserDao();	
}
