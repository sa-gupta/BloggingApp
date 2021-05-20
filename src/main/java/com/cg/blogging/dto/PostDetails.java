package com.cg.blogging.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.blogging.entities.PostType;

public class PostDetails {
	
	private int postId;
	private String title;
	private String createdBy;
	private PostType content;
	private String data;
	private LocalDateTime createdDateTime;
	private String flair;
	private String community; //to modify
	
	public PostDetails() {}
	
	

	public PostDetails(int postId, String title, String createdBy, PostType content, String data,
			LocalDateTime createdDateTime, String flair, String community) {
		this.postId = postId;
		this.title = title;
		this.createdBy = createdBy;
		this.content = content;
		this.data = data;
		this.createdDateTime = createdDateTime;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
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

	public String getFlair() {
		return flair;
	}

	public void setFlair(String flair) {
		this.flair = flair;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}
	
	
}
