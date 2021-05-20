package com.cg.blogging.dto;

import java.util.List;

public class BloggerDetails {

	private int userId;
	private String bloggerName;
	private int karma;
	private List<String> communityName;
	
	
	
	
	public BloggerDetails(int userId, String bloggerName, int karma, List<String> communityName) {
		this.userId = userId;
		this.bloggerName = bloggerName;
		this.karma = karma;
		this.communityName = communityName;
	}

	public BloggerDetails() {
	}

	
	
	public List<String> getCommunityName() {
		return communityName;
	}

	public void setCommunityName(List<String> communityName) {
		this.communityName = communityName;
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
