package com.cg.blogging.entities;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 
 * <h1>Moderator Class</h1>
 * <p>
 * This class moderates/shadows 
 * the comments and posts 
 * that have sensitive content.
 * 
 *  @author SKSSS
 *
 */

@Entity
@DiscriminatorValue("MODERATOR")
public class Moderator extends Blogger {
	/**
	 * Moderator class constructor.
	 */
	
	public boolean moderatesPostsAndComments() {return false;}

	public Moderator() {
		super();
	}

	public Moderator(int userId, String bloggerName, List<Post> posts, List<Comment> comments, List<Post> upvoted,
			List<Post> downvoted, List<Community> communities, int karma, String password) {
		super(userId, bloggerName, posts, comments, upvoted, downvoted, communities, karma, password);
	}

	public Moderator(int userId, String bloggerName, String password) {
		super(userId, bloggerName, password);
	}

	public Moderator(int userId) {
		super(userId);
	}

	public Moderator(String bloggerName, List<Post> posts, List<Comment> comments, List<Post> upvoted,
			List<Post> downvoted, List<Community> communities, int karma, String password) {
		super(bloggerName, posts, comments, upvoted, downvoted, communities, karma, password);
	}

	
}
