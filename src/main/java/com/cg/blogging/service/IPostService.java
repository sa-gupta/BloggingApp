package com.cg.blogging.service;

import java.util.List;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Post;

/**
 * 
 * <h1>Post Service Interface</h1>
 * <p>
 * This interface provides with all the methods to be implemented by the Post
 * Service Class
 * 
 * @author SKSSS
 *
 */
public interface IPostService {

	public Post addPost(Post post);

	public Post updatePost(Post post);

	public Post deletePost(int id);

	public List<Post> getPostBySearchString(String searchStr);

	public List<Post> getPostByBlogger(int id);

	public void upVote(boolean upVote);

	public List<Post> getAllPost();

	public Post getPostById(int id);

	public List<Post> getPostByCommunity(int id);

}
