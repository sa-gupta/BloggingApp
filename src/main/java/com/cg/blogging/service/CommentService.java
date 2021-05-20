package com.cg.blogging.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.data.repository.CrudRepository;

import com.cg.blogging.dao.ICommentRepository;
//import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Comment;
import com.cg.blogging.entities.Post;
//import com.cg.blogging.entities.Community;
import com.cg.blogging.exception.IdNotFoundException;
import com.cg.blogging.util.ExceptionMessage;

/**
 * 
 * <h1>Comment Service Class</h1>
 * <p>
 * This class allows to manage comments by providing create and delete
 * operations using comment class. The operations can be called like:
 * {@link #addComment(Comment)},{@link #deleteComment(Comment)} This even allows
 * to get all the comments related to a particular post by using:
 * {@link #getAllCommentForPost()}
 * 
 * 
 * @author Sataym Kukreja
 *
 */
@Service
@Transactional
public class CommentService implements ICommentService {

	private Logger logger = Logger.getLogger(CommentService.class);
	@Autowired
	private ICommentRepository cRepo;

	/**
	 * This method adds the Comment on a post. It calls the save method of
	 * ICommentRepository
	 * 
	 * @param Comment
	 * @return Comment
	 */
	@Override
	public Comment addComment(Comment comment) {
		System.out.println(comment);
		Comment com = cRepo.save(comment);
		logger.info("Comment added : " + com);
//		System.out.println(com.getBlogger().getBloggerName()+"in service...");
		return com;
	}

	/**
	 * Comment Service method to delete a comment details from the repository.
	 * 
	 * @exception IdNotFoundException
	 */
	@Override
	public void deleteComment(int id) {
		Optional<Comment> p1 = cRepo.findById(id);
		if (!p1.isPresent()) {
			throw new IdNotFoundException(ExceptionMessage.ID_NOT_FOUND);
		}
		cRepo.deleteById(id);
		logger.info(" Comment deleted : " + p1.get().getCommentId() + " " + p1.get().getCommentDescription() + " "
				+ p1.get().getVotes());
	}

	@Override
	public List<Comment> listAllCommentsByPost(int postId) {
		return cRepo.listAllCommentsByPost(postId);
	}

	/**
	 * <p>
	 * Comment Service method to vies all the comment related to a particular post
	 * by fetching details from post and comment repositories.
	 */

	/**
	 * Comment Service method to vote for a comment.
	 */
//	@Override
//	public void upVote(boolean upVote) {
//		((CommentService) commentRepo).upVote(upVote);
//	}

}
