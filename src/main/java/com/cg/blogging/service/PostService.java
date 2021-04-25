package com.cg.blogging.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Post;
import com.cg.blogging.exception.IdNotFoundException;
import com.cg.blogging.repository.IPostRepository;
/**
 * 
 * <h1>Post Service Class</h1>
 * <p>
 * This class allows to manage posts by providing CRUD operations using post
 * class. The CRUD operations can be called like:
 * {@link #addPost(Post)},{@link #updatePost(Post)},{@link #deletePost(int)},
 * {@link #getPostByBlogger(Blogger)} and so on.
 * 
 * @author SKSSS
 *
 */
@Service("pService")
@Transactional
public class PostService implements IPostService {

	private Logger logger = Logger.getLogger(PostService.class);
	
	@Autowired
	private IPostRepository pRepo;
	
	/**
	 * Post Service method to add new post details into the post repository.
	 */
	@Override
	public Post addPost(Post post) {
		Post returnPost = pRepo.save(post);
		logger.info("Post Created : "+returnPost);
		return returnPost;
	}

	/**
	 * <p>
	 * Post Service method to update a existing post details by finding the postId
	 * in the post repository.
	 * Injecting the changed post details into the repository.
	 * 
	 * @exception IdNotFoundException
	 */
	@Override
	public Post updatePost(Post post) {
		Optional<Post> opt = pRepo.findById(post.getPostId());
		if(!opt.isPresent()) {
			throw new IdNotFoundException("Post not Available");
		}
		Post recordInDatabse = opt.get();
		Post toBeUpdated = new Post(recordInDatabse.getPostId(), post.getTitle(), recordInDatabse.getCreatedBy(), 
				post.getContent(), null, null, post.getVotes(), true, false, true, true, post.getFlair(), recordInDatabse.getCommunity());
		Post rPost = pRepo.save(toBeUpdated);
		return rPost;
	}
	
	/**
	 * Post Service method to delete a post and it's details from the post repository.
	 */
	@Override
	public Post deletePost(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Post Service method to find a post by using searchstring provided from the repository.
	 */
	@Override
	public List<Post> getPostBySearchString(String searchStr) {
		return null;
	}

	/**
	 * Post Service method to find a post by a particular blogger from post and blogger repositories.
	 */
	@Override
	public List<Post> getPostByBlogger(Blogger blogger) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Post Service method to vote for a post.
	 */
	@Override
	public void upVote(boolean upVote) {
		// TODO Auto-generated method stub

	}

}
