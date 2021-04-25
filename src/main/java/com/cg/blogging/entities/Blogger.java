package com.cg.blogging.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 
 * <h1>Blogger Class</h1>
 * <p>
 * This class is used for creating and
 * managing the blogger.
 * Posts, awards, communities and all
 * other details related to a blogger
 * are accessed through this class.
 *  
 * @author SKSSS
 *
 */
@Entity
@Table
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="blogger_type", discriminatorType=DiscriminatorType.STRING)
//@DiscriminatorValue("BLOGGER")
public class Blogger {	
	@Id
//	@GeneratedValue
	private int userId;
	@NotBlank 
	@Pattern(regexp = "^[A-Za-z ]\\w{3,19}$", message = "bloggerName must be 4 to 20 characters long with first letter alphabet")
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
	@ManyToMany
	private List<Community> communities = new ArrayList<>();
	private int karma;
	@NotBlank
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#%&*$])(?=\\S+$).{8,16}$", 
			message = "password must be 8 to 16 characters long and consist of at least :"
					+ " one digit, one lowercase alphabet, one Uppercase alphabet and one special character in the bracket with No white space allowed.")
	private String password;
	/**
	 * Blogger class constructor.
	 */
	public Blogger() {
	}
	
	/**
	 * <p>
	 * Blogger class constructor
	 * to create a blogger
	 * by passing this argument.
	 * 
	 * @param userId
	 */
	public Blogger(int userId) {
		this.userId = userId;
	}

	/**
	 * <p>
	 * Blogger class constructor
	 * to create a blogger
	 * by passing these arguments.
	 * 
	 * @param userId
	 * @param bloggerName
	 * @param password
	 */
	public Blogger(int userId,String bloggerName, String password) {
		this.userId = userId;
		this.bloggerName = bloggerName;
		this.password = password;
	}



	/**
	 * <p>
	 * Blogger class constructor
	 * to create a blogger
	 * by passing these arguments.
	 * 
	 * @param userId
	 * @param bloggerName
	 * @param posts
	 * @param comments
	 * @param upvoted
	 * @param downvoted
	 * @param communities
	 * @param karma
	 * @param password
	 */
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

	/**
	 * <p>
	 * Blogger class constructor
	 * to create a blogger
	 * by passing these arguments.
	 * 
	 * @param bloggerName
	 * @param posts
	 * @param comments
	 * @param upvoted
	 * @param downvoted
	 * @param communities
	 * @param karma
	 * @param password
	 */
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
