package com.cg.blogging.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * 
 * <h1>Comment Class</h1>
 * <p>
 * This class is used for creating and managing the comments being posted by the
 * user.
 * 
 * @author SKSSS
 *
 */
@Entity
@Table(name = "comment_table")
public class Comment {
	@Id
	@SequenceGenerator(allocationSize = 1, name = "seq1", sequenceName = "comment_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq1")
	private int commentId;
	@Size(min = 5, max = 40, message = "Comment description should be between 5 to 40 characters long")
	private String commentDescription;
	private int votes;
	@ManyToOne
	@JoinColumn(name = "blogger_id")
	private Blogger blogger;
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	private boolean voteUp;

	/**
	 * Comment class constructor.
	 */
	public Comment() {
	}

	/**
	 * 
	 * <p>
	 * Comment class constructor to create a comment by passing these arguments.
	 * 
	 * @param commentDescription
	 * @param blogger
	 * @param post
	 */
	public Comment(String commentDescription, Blogger blogger, Post post) {
		super();
		this.commentDescription = commentDescription;
		this.blogger = blogger;
		this.post = post;
	}

	/**
	 * <p>
	 * Comment class constructor to create a comment by passing these arguments.
	 * 
	 * @param commentDescription
	 * @param votes
	 * @param blogger
	 * @param post
	 * @param voteUp
	 */
	public Comment(String commentDescription, int votes, Blogger blogger, Post post, boolean voteUp) {
		this.commentDescription = commentDescription;
		this.votes = votes;
		this.blogger = blogger;
		this.post = post;
		this.voteUp = voteUp;
	}

	/**
	 * <p>
	 * Comment class constructor to create a comment by passing these arguments.
	 * 
	 * @param commentDescription
	 * @param votes
	 * @param blogger
	 * @param voteUp
	 */
	public Comment(String commentDescription, int votes, Blogger blogger, boolean voteUp) {
		this.commentDescription = commentDescription;
		this.votes = votes;
		this.blogger = blogger;
		this.voteUp = voteUp;
	}

	/**
	 * <p>
	 * Comment class constructor to create a comment by passing these arguments.
	 * 
	 * @param commentId
	 * @param commentDescription
	 * @param votes
	 * @param blogger
	 * @param post
	 * @param voteUp
	 */
	public Comment(int commentId, String commentDescription, int votes, Blogger blogger, Post post, boolean voteUp) {
		super();
		this.commentId = commentId;
		this.commentDescription = commentDescription;
		this.votes = votes;
		this.blogger = blogger;
		this.post = post;
		this.voteUp = voteUp;
	}

	/**
	 * <p>
	 * Comment class constructor to create a comment by passing this argument.
	 * 
	 * @param commentId
	 */
	public Comment(Integer commentId) {
		this.commentId = commentId;
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

	public Blogger getBlogger() {
		return blogger;
	}

	public void setBlogger(Blogger blogger) {
		this.blogger = blogger;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public boolean isVoteUp() {
		return voteUp;
	}

	public void setVoteUp(boolean voteUp) {
		this.voteUp = voteUp;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentDescription=" + commentDescription + ", votes=" + votes
				+ ", blogger=" + blogger + ", post=" + post + ", voteUp=" + voteUp + "]";
	}

}
