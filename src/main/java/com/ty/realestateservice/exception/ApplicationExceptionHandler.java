package com.ty.realestateservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.ty.realestateservice.util.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoIdFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noIdHandler(NoIdFoundException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("id is not found");
		responseStructure.setData(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NoNameFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noNameHandler(NoNameFoundException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		((Object) responseStructure).setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Name is not found");
		responseStructure.setData(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoEmailFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noEmailHandler(NoEmailFoundException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("email not found");
		responseStructure.setData(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(NoLocationFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noLocationHandler(NoLocationFoundException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("location not found");
		responseStructure.setData(exception.getMessage());

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

}
