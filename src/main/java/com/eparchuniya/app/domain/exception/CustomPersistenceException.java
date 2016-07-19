package com.eparchuniya.app.domain.exception;

public class CustomPersistenceException extends javax.persistence.PersistenceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7383126779828637764L;

	public String message = "exception while persisting the entity -->";
	
	public CustomPersistenceException(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.getMessage();
	}
}
