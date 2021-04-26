package com.cg.blogging.exception;
/**
 * 
 * <h1>UserNotFound Exception Class</h1>
 * <p>
 * This class handles the Id not found exception 
 * It passes the message and cause to the 
 * centralized handler.
 * 
 * @author Sachin Gupta
 *
 */
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotFoundException(String message) {
		super(message);
	}
	
}
