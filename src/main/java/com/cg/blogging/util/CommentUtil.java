package com.cg.blogging.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.blogging.dto.CommentDetails;
import com.cg.blogging.entities.Comment;

@Component
public class CommentUtil {

//	@Autowired
//	private BloggerUtil bUtil;
	
	public List<CommentDetails> toDetails(List<Comment> comments) {
		List<CommentDetails> commentDetailList = new ArrayList<>();
		for (Comment comment : comments) {
			commentDetailList.add(toDetails(comment));
		}		
		return commentDetailList;
	}

	private CommentDetails toDetails(Comment comment) {
		CommentDetails commentDetails = new CommentDetails(comment.getCommentId(), comment.getCommentDescription(), 
				comment.getVotes(), comment.getBlogger(), comment.getPost());
		return commentDetails;
	}

}
