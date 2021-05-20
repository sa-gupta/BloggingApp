package com.cg.blogging.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.blogging.dto.CommentDetails;
import com.cg.blogging.entities.Comment;

@Component
public class CommentUtil {

	@Autowired
	BloggerUtil bUtil;
	
	public CommentDetails commentToCommentDetails (Comment comment) {
		CommentDetails cDetail = new CommentDetails(comment.getCommentId(), comment.getCommentDescription(),
				comment.getVotes(), comment.getBlogger().getBloggerName() ,comment.getCreatedOn());
		System.out.println(comment.getCommentId()+" in util...");
		return cDetail;
	}

	public List<CommentDetails> commentListToCommentDetailsList(List<Comment> comments) {
		if(comments==null) {
			System.out.println("comment list null");
		}
		List<CommentDetails> list = comments.stream().map(c -> commentToCommentDetails(c)).collect(Collectors.toList());
		return list;
	}
}
