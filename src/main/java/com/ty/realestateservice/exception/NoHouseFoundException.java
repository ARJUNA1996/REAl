package com.ty.realestateservice.exception;

public class NoHouseFoundException extends RuntimeException {

	String message = "No house found";

	public NoHouseFoundException(String message) {
		super();
		this.message = message;
	}

	public NoHouseFoundException() {
		super();
	}

	public String getMessage() {
		return message;
	}

}
