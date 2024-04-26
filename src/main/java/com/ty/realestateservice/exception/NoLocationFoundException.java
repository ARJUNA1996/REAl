package com.ty.realestateservice.exception;

public class NoLocationFoundException extends RuntimeException {
	String message = "no location found";

	public NoLocationFoundException(String message) {
		super();
		this.message = message;
	}

	public NoLocationFoundException() {

	}

	public String getMessage() {
		return message;
	}

}
