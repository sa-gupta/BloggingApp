package com.cg.blogging.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(WrongCredentials.class)
	public String handleWrongCredentials(WrongCredentials e) {
		return e.getMessage();
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(IdNotFoundException.class)
	public String handleIdNotFoundException(IdNotFoundException e) {
		return e.getMessage();
	}
	
	
}
