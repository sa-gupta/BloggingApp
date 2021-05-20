package com.cg.blogging.dto;

import java.time.LocalDateTime;

public class CommentDetails {
	
	private int commentId;
	private String commentDescription;
	private int votes;
	private String bloggerName;
	private LocalDateTime createdOn;
	
	public CommentDetails() {}
	
	public CommentDetails(int commentId, String commentDescription, int votes, String bloggerName,
			LocalDateTime createdOn) {
		this.commentId = commentId;
		this.commentDescription = commentDescription;
		this.votes = votes;
		this.bloggerName = bloggerName;
		this.createdOn = createdOn;
	}
	
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getCommentDescription() {
		return commentDescription;
	}
	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}

	public String getBloggerName() {
		return bloggerName;
	}

	public void setBloggerName(String bloggerName) {
		this.bloggerName = bloggerName;
	}
	
	
	
}
