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
				comment.getVotes(), bUtil.bloggerToBloggerDetails(comment.getBlogger()));
		return cDetail;
	}

	public List<CommentDetails> commentListToCommentDetailsList(List<Comment> comments) {
		List<CommentDetails> list = comments.stream().map(c -> commentToCommentDetails(c)).collect(Collectors.toList());
		return list;
	}
}
