package com.cg.blogging.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment_table")
public class Comment {
	@Id
	@GeneratedValue
	private int commentId;
	private String commentDescription;
	private int votes;
	@OneToOne
	private Blogger blogger;
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	private boolean voteUp;
	
	public Comment() {
	}
	
	public Comment(String commentDescription, int votes, Blogger blogger, Post post, boolean voteUp) {
		this.commentDescription = commentDescription;
		this.votes = votes;
		this.blogger = blogger;
		this.post = post;
		this.voteUp = voteUp;
	}

	public Comment(String commentDescription, int votes, Blogger blogger, boolean voteUp) {
		this.commentDescription = commentDescription;
		this.votes = votes;
		this.blogger = blogger;
		this.voteUp = voteUp;
	}
	
	public Comment(int commentId, String commentDescription, int votes, Blogger blogger, Post post, boolean voteUp) {
		super();
		this.commentId = commentId;
		this.commentDescription = commentDescription;
		this.votes = votes;
		this.blogger = blogger;
		this.post = post;
		this.voteUp = voteUp;
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

