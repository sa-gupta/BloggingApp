package com.cg.blogging.dto;

public class CommentDetails {
	
	private int commentId;
	private String commentDescription;
	private int votes;
	private BloggerDetails blogger;
	
	public CommentDetails() {}
	
	
	
	public CommentDetails(int commentId, String commentDescription, int votes, BloggerDetails blogger) {
		this.commentId = commentId;
		this.commentDescription = commentDescription;
		this.votes = votes;
		this.blogger = blogger;
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
	public BloggerDetails getBlogger() {
		return blogger;
	}
	public void setBlogger(BloggerDetails blogger) {
		this.blogger = blogger;
	}
	
	
}
