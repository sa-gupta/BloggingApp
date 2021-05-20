package com.cg.blogging.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.blogging.dto.CommentDetails;
import com.cg.blogging.dto.CommentRequest;
import com.cg.blogging.entities.Comment;
import com.cg.blogging.entities.Post;
import com.cg.blogging.service.ICommentService;
import com.cg.blogging.util.CommentUtil;

/**
 * 
 * <h1>Comment Controller Class</h1>
 * <p>
 * This class allows to inject comment's details through service class by
 * providing create and delete operations using comment class. The operations
 * can be called like:
 * {@link #addComment(Comment)},{@link #deleteComment(Comment)} This even allows
 * to request all the comments related to a particular post by using:
 * {@link #getAllCommentForPost()}
 * 
 * 
 * @author Satyam Kukreja
 *
 */
@RestController
@RequestMapping("/comment")
@Validated
public class CommentController {
	@Autowired
	private ICommentService cService;

	@Autowired
	private CommentUtil cUtil;

	/**
	 * To inject the details of a new comment into the repository.
	 * 
	 * @param Comment
	 * @return Comment
	 */
//	@ResponseStatus(code = HttpStatus.CREATED)
//	@PostMapping("/add")
//	public CommentDetails addComment(@RequestBody @Valid Comment comment) {
//		Comment com = cService.addComment(comment);
//		System.out.println(com.getBlogger().getBloggerName()+"in controller...");
//		return cUtil.commentToCommentDetails(com);
////		return com;
//	}

	/**
	 * To request the details of a comment and delete it from repository.
	 * 
	 * @param commentId
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{id}")
	public void deleteComment(@PathVariable("id") Integer commentId) {
		cService.deleteComment(commentId);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/all/{postId}")
	public List<CommentDetails> listAllCommentsByPost(@PathVariable("postId") int postId) {
		return cUtil.commentListToCommentDetailsList(cService.listAllCommentsByPost(postId));

	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/add")
	public boolean addCommentTest(@RequestBody CommentRequest comment) {
//		System.out.println(comment);
//		System.out.println(cUtil.commentReqToComment(comment).getBlogger().getUserId());
//		System.out.println(cService.addComment(cUtil.commentReqToComment(comment)));
		
		if(cService.addComment(cUtil.commentReqToComment(comment)).getCommentId()>0) {
			return true;
		}
		
		return false;
	}
	
	

	/**
	 * To update the new vote that is added to the comment.
	 */
//	@ResponseStatus(code = HttpStatus.OK)
//	@PostMapping("/upVote")	
//	public void upVote(@RequestBody boolean upvote) {
//		System.out.println("Request comment : "+upvote);
//		cService.upVote(upvote);
//	}

}
