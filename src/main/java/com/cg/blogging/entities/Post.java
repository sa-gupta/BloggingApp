package com.cg.blogging.entities;

import java.time.LocalDateTime;
//import java.nio.file.Files;
//import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//import org.checkerframework.common.value.qual.BoolVal;

@Entity
@Table(name = "post_table")
public class Post {
	@Id
	@SequenceGenerator(allocationSize=1, name="seq1", sequenceName="post_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq1")
	private int postId;
	private String title;
	@ManyToOne
	@JoinColumn(name = "blogger_id")
	private Blogger createdBy;
	@Enumerated(EnumType.STRING)
	private PostType content;
//	private List<Files> data;
//	private Award awardsReceived;
	@CreationTimestamp
	private LocalDateTime createdDateTime;
	@OneToMany
	@JoinColumn(name = "comments")
	private List<Comment> comments;
	private int votes;
	private boolean voteUp;
    private boolean notSafeForWork;
    private boolean spoiler;
    private boolean originalContent;
    private String flair;
    @ManyToOne
    @JoinColumn(name = "community")
    private Community community;
	
    public Post() {
	}

    
    /**
     * 
     * @param postId
     * @param title
     * @param createdBy
     * @param content
     * @param createdDateTime
     * @param comments
     * @param votes
     * @param voteUp
     * @param notSafeForWork
     * @param spoiler
     * @param originalContent
     * @param flair
     * @param community
     */



	public Post(int postId, String title, Blogger createdBy, PostType content, LocalDateTime createdDateTime,
			List<Comment> comments, int votes, boolean voteUp, boolean notSafeForWork, boolean spoiler,
			boolean originalContent, String flair, Community community) {
		super();
		this.postId = postId;
		this.title = title;
		this.createdBy = createdBy;
		this.content = content;
		this.createdDateTime = createdDateTime;
		this.comments = comments;
		this.votes = votes;
		this.voteUp = voteUp;
		this.notSafeForWork = notSafeForWork;
		this.spoiler = spoiler;
		this.originalContent = originalContent;
		this.flair = flair;
		this.community = community;
	}






	public Post(int postId,String title, Blogger createdBy, PostType content, String flair, Community community) {
		this.postId = postId;
		this.title = title;
		this.createdBy = createdBy;
		this.content = content;
		this.flair = flair;
		this.community = community;
	}


	public Post(int postId,String title, Blogger createdBy, PostType content, LocalDateTime createdDateTime, boolean notSafeForWork,
			boolean spoiler, boolean originalContent, String flair, Community community) {
		super();
		this.postId = postId;
		this.title = title;
		this.createdBy = createdBy;
		this.content = content;
		this.createdDateTime = createdDateTime;
		this.notSafeForWork = notSafeForWork;
		this.spoiler = spoiler;
		this.originalContent = originalContent;
		this.flair = flair;
		this.community = community;
	}

//	public Post(int postId, String title, Blogger createdBy, PostType content, Date createdDateTime,
//			List<Comment> comments, int votes, boolean voteUp, boolean notSafeForWork, boolean spoiler,
//			boolean originalContent, String flair, Community community) {
//		this.postId = postId;
//		this.title = title;
//		this.createdBy = createdBy;
//		this.content = content;
//		this.createdDateTime = createdDateTime;
//		this.comments = comments;
//		this.votes = votes;
//		this.voteUp = voteUp;
//		this.notSafeForWork = notSafeForWork;
//		this.spoiler = spoiler;
//		this.originalContent = originalContent;
//		this.flair = flair;
//		this.community = community;
//	}
	
//	public Post(String title, Blogger createdBy, PostType content, Date createdDateTime,
//			List<Comment> comments, int votes, boolean voteUp, boolean notSafeForWork, boolean spoiler,
//			boolean originalContent, String flair, Community community) {
//		this.title = title;
//		this.createdBy = createdBy;
//		this.content = content;
//		this.createdDateTime = createdDateTime;
//		this.comments = comments;
//		this.votes = votes;
//		this.voteUp = voteUp;
//		this.notSafeForWork = notSafeForWork;
//		this.spoiler = spoiler;
//		this.originalContent = originalContent;
//		this.flair = flair;
//		this.community = community;
//	}



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

	public Blogger getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Blogger createdBy) {
		this.createdBy = createdBy;
	}

	public PostType getContent() {
		return content;
	}

	public void setContent(PostType content) {
		this.content = content;
	}

//	public List<Files> getData() {
//		return data;
//	}
//
//	public void setData(List<Files> data) {
//		this.data = data;
//	}
//
//	public Award getAwardsReceived() {
//		return awardsReceived;
//	}
//
//	public void setAwardsReceived(Award awardsReceived) {
//		this.awardsReceived = awardsReceived;
//	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

//	public List<Comment> getComments() {
//		return comments;
//	}
//
//	public void setComments(List<Comment> comments) {
//		this.comments = comments;
//	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public boolean isVoteUp() {
		return voteUp;
	}

	public void setVoteUp(boolean voteUp) {
		this.voteUp = voteUp;
	}

	public boolean isNotSafeForWork() {
		return notSafeForWork;
	}

	public void setNotSafeForWork(boolean notSafeForWork) {
		this.notSafeForWork = notSafeForWork;
	}

	public boolean isSpoiler() {
		return spoiler;
	}

	public void setSpoiler(boolean spoiler) {
		this.spoiler = spoiler;
	}

	public boolean isOriginalContent() {
		return originalContent;
	}

	public void setOriginalContent(boolean originalContent) {
		this.originalContent = originalContent;
	}

	public String getFlair() {
		return flair;
	}

	public void setFlair(String flair) {
		this.flair = flair;
	}

	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}



	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", createdBy=" + createdBy + ", content=" + content
				+ ", createdDateTime=" + createdDateTime + ", votes=" + votes + ", voteUp=" + voteUp
				+ ", notSafeForWork=" + notSafeForWork + ", spoiler=" + spoiler + ", originalContent=" + originalContent
				+ ", flair=" + flair + ", community=" + community + "]";
	}

	

	
    
	
	



}
