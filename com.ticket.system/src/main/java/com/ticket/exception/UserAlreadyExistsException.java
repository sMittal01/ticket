package com.ticket.exception;

public class UserAlreadyExistsException extends Exception {

	private String message;
	
	public UserAlreadyExistsException(String message){
		this.message = message;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getLocalizedMessage(){
		return message;
		
	}

}
