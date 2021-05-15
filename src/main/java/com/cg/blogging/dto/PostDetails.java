package com.cg.blogging.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.blogging.entities.PostType;

public class PostDetails {
	
	private int postId;
	private String title;
	private BloggerDetails createdBy;
	private PostType content;
	private String data;
	private LocalDateTime createdDateTime;
	private List<CommentDetails> comments;
	private String flair;
	private CommunityDetails community; //to modify
	
	public PostDetails() {}
	
	

	public PostDetails(int postId, String title, BloggerDetails createdBy, PostType content, String data,
			LocalDateTime createdDateTime, List<CommentDetails> comments, String flair, CommunityDetails community) {
		this.postId = postId;
		this.title = title;
		this.createdBy = createdBy;
		this.content = content;
		this.data = data;
		this.createdDateTime = createdDateTime;
		this.comments = comments;
		this.flair = flair;
		this.community = community;
	}



	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BloggerDetails getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(BloggerDetails createdBy) {
		this.createdBy = createdBy;
	}

	public PostType getContent() {
		return content;
	}

	public void setContent(PostType content) {
		this.content = content;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public List<CommentDetails> getComments() {
		return comments;
	}

	public void setComments(List<CommentDetails> comments) {
		this.comments = comments;
	}

	public String getFlair() {
		return flair;
	}

	public void setFlair(String flair) {
		this.flair = flair;
	}

	public CommunityDetails getCommunity() {
		return community;
	}

	public void setCommunity(CommunityDetails community) {
		this.community = community;
	}
	
	
}
