package com.jocata.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class UserMasterDto {
	
	
	private int id;
	
	
	private String UserName;

	private String PassWord;
	
	
	private String Name;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return UserName;
	}


	public void setUserName(String userName) {
		UserName = userName;
	}


	public String getPassWord() {
		return PassWord;
	}


	public void setPassWord(String passWord) {
		PassWord = passWord;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}

		

}
