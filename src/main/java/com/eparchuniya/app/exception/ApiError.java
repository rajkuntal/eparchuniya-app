package com.eparchuniya.app.exception;

import java.util.Arrays;
import java.util.List;

public class ApiError {
	
	private int ResponseCode;
	private List<String> errors;
	
	public ApiError(List<String> errors) {
		super();
		this.errors = errors;
	}
	
	public ApiError(ResponseCode code, List<String> errors) {
		super();
		this.errors = errors;
		this.setResponseCode(code.getCode());
	}
	
	public ApiError(ResponseCode code, String error) {
		super();
		this.errors = Arrays.asList(error);
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public int getResponseCode() {
		return ResponseCode;
	}

	public void setResponseCode(int responseCode) {
		ResponseCode = responseCode;
	}

}
