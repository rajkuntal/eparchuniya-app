package com.graminmart.app.exception;

public enum ResponseCode {
			OK(100),
			ERROR(101),
			BAD_REQUEST(102),
			UNIQUE_KEY_VIOLATION(103),
			NOT_FOUND(104);
	
	private final int code;
	
	private ResponseCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
