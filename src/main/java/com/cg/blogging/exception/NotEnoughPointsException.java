package com.cg.blogging.exception;

/**
 * 
 * <h1>Not Enough Points Exception Class</h1>
 * <p>
 * This class manages the exceptions arise due to count and award distribution.
 * 
 * @author SKSSS
 *
 */
public class NotEnoughPointsException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Class constructor
	 */
	public NotEnoughPointsException() {

	}

	/**
	 * Class constructor with arguments
	 * 
	 * @param message
	 * @param cause
	 */
	public NotEnoughPointsException(String message, Throwable cause) {
		super(message, cause);
	}

}
