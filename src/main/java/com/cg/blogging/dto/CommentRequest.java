package com.cg.blogging.dto;

import java.time.LocalDateTime;

public class CommentRequest {
	private int commentId;
	private String commentDescription;
	private String bloggerName;
	private LocalDateTime createdOn;
	private int votes;
	private int bloggerId;
	private int postId;
	
	public CommentRequest() {
	}

	public CommentRequest(int commentId, String commentDescription, String bloggerName, LocalDateTime createdOn,
			int votes, int bloggerId, int postId) {
		this.commentId = commentId;
		this.commentDescription = commentDescription;
		this.bloggerName = bloggerName;
		this.createdOn = createdOn;
		this.votes = votes;
		this.bloggerId = bloggerId;
		this.postId = postId;
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

	public String getBloggerName() {
		return bloggerName;
	}

	public void setBloggerName(String bloggerName) {
		this.bloggerName = bloggerName;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getBloggerId() {
		return bloggerId;
	}

	public void setBloggerId(int bloggerId) {
		this.bloggerId = bloggerId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	
}
