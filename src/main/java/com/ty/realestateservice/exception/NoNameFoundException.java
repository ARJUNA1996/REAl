package com.ty.realestateservice.exception;

public class NoNameFoundException extends RuntimeException {
	String message = "no name found";

	public NoNameFoundException() {

	}

	public NoNameFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
