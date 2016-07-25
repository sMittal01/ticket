package com.ticket.system.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "UserInfo")
public class LogonBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LogonBean(){
		
	}

	/**
	 * Constructor
	 * @param userName
	 * @param password
	 */
	public LogonBean(String userName, String password){
		this.password = password;
		this.userName = userName;
	}
	
	@Id
	@Column(name="userName")
	private String userName;
	
	@Column(name = "password")
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
