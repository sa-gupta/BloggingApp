package com.cg.blogging.exception;

/**
 * 
 * <h1>Moderator Approval Exception Class</h1>
 * <p>
 * This class handles the exceptions arise during shadowing of post or comments.
 * 
 * @author SKSSS
 *
 */
public class ModeratorApprovalException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Class constructor
	 */
	public ModeratorApprovalException() {

	}

	/**
	 * Class constructor with arguments:
	 * 
	 * @param message
	 * @param cause
	 */
	public ModeratorApprovalException(String message, Throwable cause) {
		super(message, cause);
	}

}
