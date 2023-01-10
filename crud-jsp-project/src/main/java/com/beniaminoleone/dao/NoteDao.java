package com.beniaminoleone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.beniaminoleone.model.Note;
import com.beniaminoleone.model.Privileges;
import com.beniaminoleone.model.User;
import com.beniaminoleone.service.UserService;

public class NoteDao {
	
	public int createNote(String username, String note, Connection c) {
		int status = 0;
		try {
			PreparedStatement ps = c.prepareStatement("Insert into notes (str, xUsername) values (?, ?)");	
			ps.setString(1, note);
			ps.setString(2, username);
			status = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return status;
		}	
	}
	
	public int deleteNoteById(int n, Connection c) {
		int status = 0;
			try {
				PreparedStatement ps = c.prepareStatement("delete from notes where idnote = ? ");	
				ps.setInt(1, n);
				status = ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				return status;
			}		
		}
	
	public static List<Note> getAllUserNotes(Connection c, User u){
		List<Note> list = new LinkedList<>(); 
		try {
			PreparedStatement ps = c.prepareStatement("Select * from notes where xUsername = ?");
			ps.setString(1, u.getUsername());
			ResultSet rs = ps.executeQuery();
				while(rs.next()){
					list.add(new Note(rs.getInt(1), rs.getString(2), rs.getString(3)));
				}
				rs.close();
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;	
	}	
	
	public static List<Note> getAllUserNotes(Connection c, String username){
		List<Note> list = new LinkedList<>(); 
		try {
			PreparedStatement ps = c.prepareStatement("Select * from notes where xUsername = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
				while(rs.next()){
					list.add(new Note(rs.getInt(1), rs.getString(2), rs.getString(3)));
				}
				rs.close();
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;	
	}	


}
