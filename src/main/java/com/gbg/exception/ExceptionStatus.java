package com.gbg.exception;

/**
 *  defines the possible exceptions for GBG
 */
public enum ExceptionStatus {

	INVALID_CMD_ARGS("INVALID_CMD_ARGS", "Invalid command line argument!");

	private String code;
	private String msg;
	
	private ExceptionStatus(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}