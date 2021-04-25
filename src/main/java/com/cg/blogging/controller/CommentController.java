package com.cg.blogging.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.blogging.entities.Comment;
import com.cg.blogging.service.ICommentService;

/**
 * 
 * <h1>Comment Controller Class</h1>
 * <p>
 * This class allows to inject comment's details through service class
 * by providing create and delete operations using comment
 * class. The operations can be called like:
 * {@link #addComment(Comment)},{@link #deleteComment(Comment)} 
 * This even allows to request all the comments related to a particular post
 * by using: {@link #getAllCommentForPost()}
 * 
 * 
 * @author SKSSS
 *
 */
@RestController
@RequestMapping("/comment")
@Validated
public class CommentController {
	@Autowired
	private ICommentService cService;
	
	/**
	 * To inject the details of a new comment into the repository.
	 * 
	 * @param Comment
	 * @return Comment
	 */
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public Comment addComment(@RequestBody @Valid Comment comment) {
		System.out.println("Request comment : "+comment);
		Comment comm = cService.addComment(comment);
		return comm;
	}
	
	/**
	 * To request the details of a comment and delete it from repository.
	 * 
	 * @param commentId
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/delete/{id}")
	public void deleteComment(@PathVariable("id") Integer commentId) {
		System.out.println("Request comment : "+commentId);
		cService.deleteComment(new Comment(commentId));
	}
	
//	@ResponseStatus(code = HttpStatus.OK)
//	@GetMapping("/deleteComment/{commentId}")
//	public void deleteComment(@PathVariable("commentId") Integer commentId) throws IdNotFoundException{
//		System.out.println("Request comment : "+commentId);
//		try {
//			cService.deleteComment(commentId);
//		} catch (IdNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
	
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
