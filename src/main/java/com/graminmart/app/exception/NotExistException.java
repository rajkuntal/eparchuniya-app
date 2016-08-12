package com.graminmart.app.exception;

public class NotExistException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4253996261635455514L;
	
	private String message;
	
	public NotExistException(String message) {
		super();
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
