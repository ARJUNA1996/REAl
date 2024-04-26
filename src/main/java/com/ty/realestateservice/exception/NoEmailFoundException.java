package com.ty.realestateservice.exception;

public class NoEmailFoundException extends RuntimeException {

	String message = "No email found";

	public NoEmailFoundException(String message) {
		super();
		this.message = message;
	}

	public NoEmailFoundException() {

	}

	public String getMessage() {
		return message;
	}
}
