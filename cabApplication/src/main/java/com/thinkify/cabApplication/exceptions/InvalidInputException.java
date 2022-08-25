package com.thinkify.cabApplication.exceptions;

public class InvalidInputException extends RuntimeException {
	
private static final long serialVersionUID = 1L;
	
	private String errorMessage;
	
	public InvalidInputException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "InvalidInputException [errorMessage=" + errorMessage + "]";
	}

}
