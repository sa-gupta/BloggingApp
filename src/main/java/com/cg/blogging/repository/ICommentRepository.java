package com.cg.blogging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.blogging.entities.Comment;
/**
 * 
 * <h1>Comment Repository</h1>
 * This interface allows to manage CRUD operations on the comment database.
 * @author SKSSS
 *
 */
@Repository
public interface ICommentRepository extends JpaRepository<Comment, Integer>{
//	public Comment addComment(Comment comment);
//	public void deleteComment(Comment comment);
//	public List<Comment> listAllCommentsByPost(Post post);
//	public void upVote(boolean upVote);
	
}
