package com.cg.blogging.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.data.repository.CrudRepository;

//import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Comment;
//import com.cg.blogging.entities.Community;
import com.cg.blogging.exception.IdNotFoundException;
import com.cg.blogging.repository.ICommentRepository;
/**
 * 
 * <h1>Comment Service Class</h1>
 * <p>
 * This class allows to manage comments by providing create and delete operations using comment
 * class. The operations can be called like:
 * {@link #addComment(Comment)},{@link #deleteComment(Comment)} 
 * This even allows to get all the comments related to a particular post
 * by using: {@link #getAllCommentForPost()}
 * 
 * 
 * @author SKSSS
 *
 */
@Service
@Transactional
public class CommentService implements ICommentService {
	
	private Logger logger = Logger.getLogger(CommentService.class);
	@Autowired
	private ICommentRepository commentRepo;
	
	/**
	 * Comment Service method to add a new comment details into comment repository.
	 */
	@Override
	public Comment addComment(Comment comment) {
		
		Comment com = commentRepo.save(comment);
		logger.info("Comment added : " + com);
		return com;
	}
	
	/**
	 * Comment Service method to delete a comment details from the repository.
	 * 
	 * @exception IdNotFoundException
	 */
	@Override
	public void deleteComment(Comment comment) {
		logger.debug("Done");
//		logger.info("******** Comment deleted : " + comment);
		Optional <Comment> p1=  commentRepo.findById(comment.getCommentId());
		if (!p1.isPresent()) {
			throw new IdNotFoundException("ID not found");
		}
//		Comment com = p1.get();
		commentRepo.deleteById(comment.getCommentId());
		logger.info("******* Comment deleted : " + p1.get().getCommentId() + " " + p1.get().getCommentDescription() + " " +p1.get().getVotes());
	}

	/**
	 * <p>
	 * Comment Service method to vies all the comment related to a particular post 
	 * by fetching details from post and comment repositories.
	 */
//	@Override
//	public List<CommentsDto> getAllCommentsForPost(Long postId) {
//        Post post = postRepository.findById(postId)
//                .orElseThrow(() -> new PostNotFoundException(postId.toString()));
//        return commentRepository.findByPost(post)
//                .stream()
//                .map(commentMapper::mapToDto).collect(toList());
//    }

	/**
	 * Comment Service method to vote for a comment.
	 */
//	@Override
//	public void upVote(boolean upVote) {
//		((CommentService) commentRepo).upVote(upVote);
//	}

	
}
