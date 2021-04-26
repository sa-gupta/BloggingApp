package com.cg.blogging.exception;

/**
 * 
 * <h1>IdNotFound Exception Class</h1>
 * <p>
 * This class handles the Id not found exception It passes the message and cause
 * to the centralized handler.
 * 
 * @author Sachin Gupta
 *
 */
public class IdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Class constructor
	 */
	public IdNotFoundException() {

	}

	/**
	 * Class constructor with arguments:
	 * 
	 * @param message
	 * @param cause
	 */
	public IdNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Class constructor with arguments
	 * 
	 * @param message
	 */
	public IdNotFoundException(String message) {
		super(message);
	}

}
