package com.graminmart.app.exception;

public class SuccessResponse {
	
	private int ResponseCode;
	private String message;
	
	public SuccessResponse() {
		super();
	}
	
	public SuccessResponse(ResponseCode responseCode, String message) {
		super();
		this.ResponseCode = responseCode.getCode();
		this.message = message;
	}

	public int getResponseCode() {
		return ResponseCode;
	}

	public void setResponseCode(int responseCode) {
		ResponseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
