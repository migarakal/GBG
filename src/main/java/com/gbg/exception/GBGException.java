package com.gbg.exception;

/**
 * GBG Exception
 */
public class GBGException extends Exception {

	private String code;
	private String message;

	public GBGException(ExceptionStatus exceptionStatus) {
		super();
		this.code = exceptionStatus.getCode();
		this.message = exceptionStatus.getMsg();
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "GBGException [code=" + this.getCode() + ", message=" + this.getMessage() + "]";
	}
}