package com.cg.blogging.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PostRequest {
	private int postId;
	private String title;
	private String data;
	private String createdBy;
	LocalDateTime createdDateTime;
	private String flair;
	private String community;
	private List<CommentRequest> comments;
	private int communityId;
	private int bloggerId;
	
	public PostRequest() {
	}

	public PostRequest(int postId, String title, String data, String createdBy, LocalDateTime createdDateTime,
			String flair, String community, List<CommentRequest> comments, int communityId,int bloggerId) {
		this.postId = postId;
		this.title = title;
		this.data = data;
		this.createdBy = createdBy;
		this.createdDateTime = createdDateTime;
		this.flair = flair;
		this.community = community;
		this.comments = comments;
		this.communityId = communityId;
		this.bloggerId = bloggerId;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	public List<CommentRequest> getComments() {
		return comments;
	}

	public void setComments(List<CommentRequest> comments) {
		this.comments = comments;
	}

	public int getCommunityId() {
		return communityId;
	}

	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}

	@Override
	public String toString() {
		return "PostRequest [postId=" + postId + ", title=" + title + ", data=" + data + ", createdBy=" + createdBy
				+ ", createdDateTime=" + createdDateTime + ", flair=" + flair + ", community=" + community
				+ ", communityId=" + communityId + "]";
	}
	
	
}
