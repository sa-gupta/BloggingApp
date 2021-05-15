package com.cg.blogging.dto;




public class BloggerDetails {

	private int userId;
	private String bloggerName;
	private int karma;
	
	
	public BloggerDetails(int userId, String bloggerName, int karma) {
		this.userId = userId;
		this.bloggerName = bloggerName;
		this.karma = karma;
	}
	
	public BloggerDetails() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBloggerName() {
		return bloggerName;
	}

	public void setBloggerName(String bloggerName) {
		this.bloggerName = bloggerName;
	}

	public int getKarma() {
		return karma;
	}

	public void setKarma(int karma) {
		this.karma = karma;
	}
	
	
	
}
