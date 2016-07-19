package com.eparchuniya.app.domain.exception;

public class UniqueKeyViolationException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7557175832995280492L;
	public String message = "unique key violation";
	
	public UniqueKeyViolationException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

}
