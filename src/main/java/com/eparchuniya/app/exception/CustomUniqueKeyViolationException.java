package com.eparchuniya.app.exception;

import java.util.Iterator;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

public class CustomUniqueKeyViolationException extends DataIntegrityViolationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6354537743473488673L;
	
	private String message = "";
	private List<String> errors;

	public CustomUniqueKeyViolationException(String message){
		super(message);
		this.message = message;
	}
	
	public CustomUniqueKeyViolationException(List<String> errors){
		super(errors.get(0));
		Iterator<String> it = errors.iterator();
		while(it.hasNext())
			this.message = this.message + " -- " + it.next();
		this.errors = errors;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
