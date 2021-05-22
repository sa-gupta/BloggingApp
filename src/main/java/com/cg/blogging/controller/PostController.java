package com.cg.blogging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.blogging.dto.PostDetails;
import com.cg.blogging.dto.PostRequest;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Post;
import com.cg.blogging.service.IPostService;
import com.cg.blogging.util.PostUtil;

/**
 * 
 * <h1>Post Controller Class</h1>
 * <p>
 * This class allows to inject and request posts through service instance by
 * providing CRUD operations using post class. The CRUD operations can be called
 * like:
 * {@link #addPost(Post)},{@link #updatePost(Post)},{@link #deletePost(int)},
 * {@link #getPostByBlogger(Blogger)} and so on.
 * 
 * @author Srishti
 *
 */
@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	private IPostService pService;
	
	@Autowired
	private PostUtil pUtil;

	/**
	 * To inject new post details into repository.
	 * 
	 * @param post
	 * @return Post
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/add")
	public PostDetails addPost(@RequestBody Post post) {
		Post rPost = pService.addPost(post);
		return pUtil.postToPostDetails(rPost);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/test")
	public PostDetails addPostTest(@RequestBody PostRequest post) {
		Post rPost = pService.addPost(pUtil.postReqToPost(post));
		return pUtil.postToPostDetails(rPost);
	}

	/**
	 * <p>
	 * To request details from the user for new values. Inject them into the
	 * repository to replace with older values.
	 * 
	 * @param post
	 * @return Post
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/update")
	public boolean updatePost(@RequestBody PostRequest post) {
		
		Post rPost = pService.updatePost(pUtil.postReqToPost(post));
//		PostDetails pDetail = pUtil.postToPostDetails(rPost);
//		if(pDetail.getPostId() == post.getPostId()) {
//			return true;
//		}
		return false;
	}

	/**
	 * This function deletes the Post from database. It makes call to service layer
	 * for Delete post
	 * 
	 * 
	 * @param id
	 * @return Moderator
	 */

	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{postId}")
	public boolean deletePost(@PathVariable("postId") int id) {
		Post rPost = pService.deletePost(id);
		if(rPost.getPostId() == id) {
			return true;
		}
		return false;
	}

	/**
	 * <p>
	 * This function searches the database for post with given search String
	 * 
	 * @param searchStr
	 * @return List<Post>
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/all/{searchStr}")
	public List<PostDetails> getPostBySearchString(@PathVariable("searchStr") String searchStr) {
		return pUtil.postListToPostDetailsList(pService.getPostBySearchString(searchStr));

	}

	/**
	 * <p>
	 * This function fetches all posts from Database.
	 * 
	 * @return List<Post>
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/all")
	public List<PostDetails> getPostBySearchString() {
		return pUtil.postListToPostDetailsList(pService.getAllPost());
	}

	/**
	 * <p>
	 * This function fetches all posts of given Blogger.
	 * 
	 * @param blogger
	 * @return List<Post>
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/all/byblogger/{id}")
	public List<PostDetails> getPostByBlogger(@PathVariable int id) {
		return pUtil.postListToPostDetailsList(pService.getPostByBlogger(id));
	}
}
