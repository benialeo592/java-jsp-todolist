package com.beniaminoleone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beniaminoleone.model.Privileges;
import com.beniaminoleone.model.User;
import com.beniaminoleone.service.UserService;
import com.beniaminoleone.util.Encryption;

public class UserDao {
	
	public int createUser(User u, Connection c) {
		int status = 0;
		try {
			PreparedStatement ps = c.prepareStatement("Insert into users (firstname, surname, username, password, privileges) values (?, ?, ?, ?, ?) ");	
			ps.setString(1, u.getFirstName());
			ps.setString(2, u.getSurname());
			ps.setString(3, u.getUsername());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getPrivileges().toString());
			status = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return status;
		}	
	}
	
	public int deleteUserByUsername(User u, Connection c) {
		int status = 0;
		if(!UserService.isAdmin(u)) {	
			try {
				PreparedStatement ps = c.prepareStatement("delete from users where username = ? ");	
				ps.setString(1, u.getUsername());
				status = ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				return status;
			}		
		}else {
			return status;
		}
	}
	
	public int deleteUserById(int i, String privileges, Connection c) {
		int status = 0;
		if(!privileges.equals("ADMIN")) {	
			try {
				PreparedStatement ps = c.prepareStatement("delete from users where idusers = ? ");	
				ps.setInt(1, i);
				status = ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				return status;
			}		
		}else {
			return status;
		}
	}
	
	public static List<User> getAll(Connection c){
		List<User> list = new ArrayList<>(); 
		try {
			PreparedStatement ps = c.prepareStatement("Select * from users");
			ResultSet rs = ps.executeQuery();
				while(rs.next()){
					Privileges privileges = rs.getString(6).equals("ADMIN") ? Privileges.ADMIN : Privileges.USER; 
					list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), privileges));
				}
				rs.close();
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;	
	}	

	public boolean usernameExist(Connection c, String username){
		boolean exist = true;
		try {
			PreparedStatement ps = c.prepareStatement("Select * from users where username = ? ");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					exist = true;
				}else {
					exist = false;
				}
				rs.close();
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return exist;	
	}
	
	public boolean authenticate(Connection c, String username, String password) {
		boolean canAuthenticate = false;
		try {
			PreparedStatement ps = c.prepareStatement("Select * from users where username = ? and password = ? ");
			ps.setString(1, username);
			ps.setString(2, Encryption.encrypt(password));
			ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					canAuthenticate = true;
				}else {
					canAuthenticate = false;
				}
				rs.close();
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return canAuthenticate;	
	}
	
	public User findUserByUsername(Connection c, String username) {
		User u = new User();
		try {
			PreparedStatement ps = c.prepareStatement("Select * from users where username = ? ");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Privileges privileges = rs.getString(6).equals("ADMIN") ? Privileges.ADMIN : Privileges.USER; 
				u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), privileges);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	
		
}
	


