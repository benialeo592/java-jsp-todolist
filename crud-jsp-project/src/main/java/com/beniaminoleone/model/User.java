package com.beniaminoleone.model;

import java.util.HashMap;
import java.util.List;

public class User {
	
	private int id;
	private String firstName;
	private String surname;
	private String username;
	private String password;
	private Privileges privileges;
	private List<Note> notes;
	
	public User(int id, String firstName, String surname, String username, String password, Privileges privileges) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.privileges = privileges;
	}
	
	public User(int id, String firstName, String surname, String username, String password, Privileges privileges, List<Note> notes) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.surname = surname;
		this.username = username;
		this.password = password;
		this.privileges = privileges;
		this.notes = notes;
	}
	

	public User() {

	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Privileges getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Privileges privileges) {
		this.privileges = privileges;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", surname=" + surname + ", username=" + username
				+ ", password=" + password + ", privileges=" + privileges + "]";
	}

	
	
}
