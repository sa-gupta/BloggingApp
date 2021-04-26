package com.cg.blogging.exception;

/**
 * 
 * <h1>Wrong Credentials Exception Class</h1>
 * <p>
 * This class handles exceptions that arise due to providing wrong credentials
 * in the details.
 * 
 * @author SKSSS
 *
 */
public class WrongCredentialsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Class constructor with arguments
	 * 
	 * @param message
	 */
	public WrongCredentialsException(String message) {
		super(message);
	}

}
