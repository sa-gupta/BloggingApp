package com.cg.blogging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Post;
import com.cg.blogging.service.IPostService;

/**
 * 
 * <h1>Post Controller Class</h1>
 * <p>
 * This class allows to inject and request posts through service instance
 * by providing CRUD operations using post class.
 * The CRUD operations can be called like:
 * {@link #addPost(Post)},{@link #updatePost(Post)},{@link #deletePost(int)},
 * {@link #getPostByBlogger(Blogger)} and so on.
 * 
 * @author SKSSS
 *
 */
@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	private IPostService pService;
	
	/**
	 * To inject new post details into repository.
	 * 
	 * @param post
	 * @return Post
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/add")
	public Post addPost(@RequestBody Post post) {
		System.out.println("Add Request from client : "+post);
		Post rPost = pService.addPost(post);
		return rPost;
	}
	
	/**
	 * <p>
	 * To request details from the user for new values.
	 * Inject them into the repository to replace with older values.
	 * 
	 * @param post
	 * @return Post
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/update")
	public Post updatePost(@RequestBody Post post) {
		System.out.println("Update request from client : "+post);
		Post rPost = pService.updatePost(post);
		return rPost;
	}
}
