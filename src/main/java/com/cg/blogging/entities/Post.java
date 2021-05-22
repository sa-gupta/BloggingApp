package com.cg.blogging.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.validation.constraints.NotNull;
//
//import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


/**
 * 
 * <h1>Post Class</h1>
 * <p>
 * This class is used to create posts with different properties according to the
 * requirements of the user:blogger. It contains all the details related to a
 * post.
 * 
 * @author SKSSS
 *
 */
@Entity
@Table
public class Post {
	@Id
	@SequenceGenerator(allocationSize = 1, name = "seq1", sequenceName = "post_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
	private int postId;
	@NotBlank
//	@Pattern(regexp = "^[a-zA-Z\\s]{5,50}$", message = "title must be 3 to 30 characters long with first letter alphabet")
	private String title;
	@ManyToOne
	@JoinColumn(name = "blogger_id")
	private Blogger createdBy;
	@Enumerated(EnumType.STRING)
	private PostType content;
	private String data;
	@UpdateTimestamp
	private LocalDateTime createdDateTime;
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
//	@JoinColumn(name = "comments")
	private List<Comment> comments;
	private int votes;
	private boolean voteUp;
	private boolean notSafeForWork;
	private boolean spoiler;
	private boolean originalContent;
	@Size(min = 1, max = 20, message = "flair should be of 1 to 20 characters long")
	private String flair;
	@ManyToOne
	@JoinColumn(name = "community")
	private Community community;

	/**
	 * Post class constructor.
	 */
	public Post() {
	}

	public Post(int postId) {
		this.postId = postId;
	}
	
	

	public Post(int postId, @NotBlank String title, Blogger createdBy, PostType content, String data,
			LocalDateTime createdDateTime, List<Comment> comments, int votes, boolean voteUp, boolean notSafeForWork,
			boolean spoiler, boolean originalContent,
			@Size(min = 1, max = 20, message = "flair should be of 1 to 20 characters long") String flair,
			Community community) {
		this.postId = postId;
		this.title = title;
		this.createdBy = createdBy;
		this.content = content;
		this.data = data;
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

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

//	@Override
//	public String toString() {
//		return "Post [postId=" + postId + ", title=" + title + ", createdBy=" + createdBy + ", content=" + content
//				+ ", createdDateTime=" + createdDateTime + ", votes=" + votes + ", voteUp=" + voteUp
//				+ ", notSafeForWork=" + notSafeForWork + ", spoiler=" + spoiler + ", originalContent=" + originalContent
//				+ ", flair=" + flair + ", community=" + community + "]";
//	}

}
