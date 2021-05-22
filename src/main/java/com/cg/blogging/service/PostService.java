package com.cg.blogging.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.blogging.dao.IBloggerRepository;
import com.cg.blogging.dao.ICommunityRepository;
import com.cg.blogging.dao.IPostRepository;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Community;
import com.cg.blogging.entities.Post;
import com.cg.blogging.exception.CommunityNotFound;
import com.cg.blogging.exception.IdNotFoundException;
import com.cg.blogging.exception.UserNotFoundException;
import com.cg.blogging.util.ExceptionMessage;

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

	@Autowired
	private IBloggerRepository bRepo;

	@Autowired
	private ICommunityRepository cRepo;

	/**
	 * Post Service method to add new post details into the post repository.
	 */
	@Override
	public Post addPost(Post post) {
		Optional<Blogger> bloggerOpt = bRepo.findById(post.getCreatedBy().getUserId());
		Optional<Community> communityOpt = cRepo.findById(post.getCommunity().getCommunityId());
		if (!bloggerOpt.isPresent()) {
			logger.error(ExceptionMessage.USER_NOT_FOUND);
			throw new UserNotFoundException(ExceptionMessage.USER_NOT_FOUND);
		} else if (!communityOpt.isPresent()) {
			logger.error(ExceptionMessage.COMMUNITY_NOT_FOUND);
			throw new CommunityNotFound(ExceptionMessage.COMMUNITY_NOT_FOUND);
		}
		Post returnPost = pRepo.save(post);
		logger.info("Post Created : " + returnPost);
		return returnPost;
	}

	/**
	 * <p>
	 * Post Service method to update a existing post details by finding the postId
	 * in the post repository. Injecting the changed post details into the
	 * repository.
	 * 
	 * @exception IdNotFoundException
	 */
	@Override
	public Post updatePost(Post post) {
		Optional<Post> opt = pRepo.findById(post.getPostId());
		if (!opt.isPresent()) {
			throw new IdNotFoundException(ExceptionMessage.ID_NOT_FOUND);
		}
//		Post recordInDatabse = opt.get();
//		Post toBeUpdated = new Post();
//		toBeUpdated.setPostId(recordInDatabse.getPostId());
//		toBeUpdated.setTitle(recordInDatabse.getTitle());
//		toBeUpdated.setData(recordInDatabse.getData());		
		Post rPost = pRepo.save(post);
		logger.info("Post Updated : " + rPost);
		return rPost;
	}

	/**
	 * Post Service method to delete a post and it's details from the post
	 * repository.
	 */
	@Override
	public Post deletePost(int id) {
		Optional<Post> opt = pRepo.findById(id);
		if (!opt.isPresent()) {
			throw new IdNotFoundException(ExceptionMessage.POST_NOT_FOUND);
		}
		pRepo.deleteById(id);
		logger.info("Logger Deleted : " + opt.get());
		return opt.get();
	}

	/**
	 * Post Service method to find a post by using searchstring provided from the
	 * repository.
	 */
	@Override
	public List<Post> getPostBySearchString(String searchStr) {

		return pRepo.getPostBySearchString(searchStr.toLowerCase());
	}

	/**
	 * Post Service method to find a post by a particular blogger from post and
	 * blogger repositories.
	 */
	@Override
	public List<Post> getPostByBlogger(int id) {
		return pRepo.getPostByBlogger(id);
	}

	/**
	 * Post Service method to vote for a post.
	 */
	@Override
	public void upVote(boolean upVote) {}

	@Override
	public List<Post> getAllPost() {
		return pRepo.findAll();
	}

}
