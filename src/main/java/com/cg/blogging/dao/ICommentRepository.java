package com.cg.blogging.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.blogging.entities.Comment;
import com.cg.blogging.entities.Post;
/**
 * 
 * <h1>Comment Repository</h1>
 * This interface allows to manage CRUD operations on the comment database.
 * @author Satyam Kukreja
 *
 */
@Repository
public interface ICommentRepository extends JpaRepository<Comment, Integer>{

	@Query(nativeQuery = true,value = "select * from comment_table where post_id in (select post_id from post where post_id=:post_id_param)")
	public List<Comment> listAllCommentsByPost(@Param("post_id_param") int postId);
//	public void upVote(boolean upVote);
	
}
