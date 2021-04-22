package com.cg.blogging.repository;

import java.util.List;


import com.cg.blogging.entities.Comment;
import com.cg.blogging.entities.Post;

public interface ICommentRepository{
	public Comment addComment(Comment comment);
	public void deleteComment(Comment comment);
	public List<Comment> listAllCommentsByPost(Post post);
	public void upVote(boolean upVote);
	
}
