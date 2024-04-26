package com.ty.realestateservice.exception;

public class NoIdFoundException extends RuntimeException {
	String message = "no id found";

	public NoIdFoundException() {

	}

	public NoIdFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
