package com.cg.blogging.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * 
 * <h1>Centralized Exceptional Handler Class</h1>
 * <p>
 * This class allows to manage/handle all different 
 * runtime exceptions globally 
 * from a single class. 
 * 
 * @author Sachin Gupta, R.Kavya, Srishti
 *
 */
@RestControllerAdvice
public class CentralizedExceptionHandler {
	/**
	 * 
	 * To handle exception regarding wrong credentials.
	 * 
	 * @param e
	 * @return Message
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(WrongCredentials.class)
	public String handleWrongCredentials(WrongCredentials e) {
		return e.getMessage();
	}
	
	/**
	 * 
	 * To handle exception regarding Id not found.
	 * 
	 * @param e
	 * @return Message
	 */
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(IdNotFoundException.class)
	public String handleIdNotFoundException(IdNotFoundException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(CommunityNotFound.class)
	public String handleCommunityNotFoundException(CommunityNotFound e) {
		return e.getMessage();
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public String handleUserNotFoundException(UserNotFoundException e) {
		return e.getMessage();
	}
}
