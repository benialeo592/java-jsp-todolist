package com.beniaminoleone.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	
	
	private final static String url = "jdbc:mysql://localhost:3306/project";
	private final static String username = "root";
	private final static String password = "admin";
	
	
	static public Connection connecToDB() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password); 
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
}
