package com.beniaminoleone.model;

public class Note {

	private int id;
	private String str;
	private String userUsername;

	
	public Note(int id, String str, String userUsername) {
		super();
		this.id = id;
		this.str = str;
		this.userUsername = userUsername;
	}
	
	public Note() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", str=" + str + ", userUsername=" + userUsername + "]";
	}
	
	

	
	
	
	
}
