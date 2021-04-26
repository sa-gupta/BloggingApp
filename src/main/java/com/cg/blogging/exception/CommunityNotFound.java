package com.cg.blogging.exception;

/**
 * 
 * <h1>Community Not Found Exception Class</h1>
 * <p>
 * This class manages the exception 
 * arise due to not being able to 
 * find the particular community details.
 * 
 * @author Sachin Gupta
 *
 */

public class CommunityNotFound extends RuntimeException{

	public CommunityNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CommunityNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public CommunityNotFound(String message) {
		super(message);
	}
	
}
