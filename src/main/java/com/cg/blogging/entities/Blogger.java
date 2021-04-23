package com.cg.blogging.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "blogger_table")
public class Blogger {
	@Id
//	@GeneratedValue
	private int userId;
	private String bloggerName;
	@OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
	private List<Post> posts = new ArrayList<>();
	@OneToMany(mappedBy = "blogger", cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();
	@OneToMany
	private List<Post> upvoted = new ArrayList<>();
	@OneToMany
	private List<Post> downvoted = new ArrayList<>();
//	private Award awardsReceived;
//	private Award awardsGiven;
	@OneToMany
	private List<Community> communities = new ArrayList<>();
	private int karma;
	private String password;
	
	public Blogger() {
	}

	public Blogger(int userId) {
		this.userId = userId;
	}

	public Blogger(int userId,String bloggerName, String password) {
		this.userId = userId;
		this.bloggerName = bloggerName;
		this.password = password;
	}



	public Blogger(int userId, String bloggerName, List<Post> posts, List<Comment> comments, List<Post> upvoted,
			List<Post> downvoted, List<Community> communities, int karma, String password) {
		super();
		this.userId = userId;
		this.bloggerName = bloggerName;
		this.posts = posts;
		this.comments = comments;
		this.upvoted = upvoted;
		this.downvoted = downvoted;
		this.communities = communities;
		this.karma = karma;
		this.password = password;
	}

	public Blogger(String bloggerName, List<Post> posts, List<Comment> comments, List<Post> upvoted,
			List<Post> downvoted, List<Community> communities, int karma, String password) {
		this.bloggerName = bloggerName;
		this.posts = posts;
		this.comments = comments;
		this.upvoted = upvoted;
		this.downvoted = downvoted;
		this.communities = communities;
		this.karma = karma;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getBloggerName() {
		return bloggerName;
	}

	public void setBloggerName(String bloggerName) {
		this.bloggerName = bloggerName;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Post> getUpvoted() {
		return upvoted;
	}

	public void setUpvoted(List<Post> upvoted) {
		this.upvoted = upvoted;
	}

	public List<Post> getDownvoted() {
		return downvoted;
	}

	public void setDownvoted(List<Post> downvoted) {
		this.downvoted = downvoted;
	}

	public List<Community> getCommunities() {
		return communities;
	}

	public void setCommunities(List<Community> communities) {
		this.communities = communities;
	}

	public int getKarma() {
		return karma;
	}

	public void setKarma(int karma) {
		this.karma = karma;
	}

	@Override
	public String toString() {
		return "Blogger [userId=" + userId + ", bloggerName=" + bloggerName + ", posts=" + posts + ", comments="
				+ comments + ", upvoted=" + upvoted + ", downvoted=" + downvoted + ", communities=" + communities
				+ ", karma=" + karma + "]";
	}
	
	
}
