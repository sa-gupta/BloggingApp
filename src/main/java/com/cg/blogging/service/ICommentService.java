package com.cg.blogging.service;

import java.util.List;

import com.cg.blogging.entities.Comment;
import com.cg.blogging.entities.Post;

/**
 * 
 * <h1>Comment Service Interface</h1>
 * <p>
 * This interface provides with all the methods to be implemented by the Comment
 * Service Class
 * 
 * @author SKSSS
 *
 */
public interface ICommentService {
	public Comment addComment(Comment comment);

	public void deleteComment(int id);

	public List<Comment> listAllCommentsByPost(int postId);
//	public void upVote(boolean upVote);

}
