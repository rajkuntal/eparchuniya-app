package com.eparchuniya.app.exception;

public enum ResponseCode {
			OK(100),
			ERROR(101),
			BADREQUEST(102),
			UNIQUEKEYVIOLATION(103),
			NOTFOUND(104);
	
	private final int code;
	
	private ResponseCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
