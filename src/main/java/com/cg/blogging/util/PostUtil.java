package com.cg.blogging.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.blogging.dto.PostDetails;
import com.cg.blogging.entities.Post;

@Component
public class PostUtil {

	@Autowired
	BloggerUtil bUtil;

	@Autowired
	CommentUtil comUtil;

	@Autowired
	CommunityUtil cUtil;

	public PostDetails postToPostDetails(Post post) {
		PostDetails dPost = new PostDetails(post.getPostId(), post.getTitle(),
				bUtil.bloggerToBloggerDetails(post.getCreatedBy()), post.getContent(), post.getData(),
				post.getCreatedDateTime(), comUtil.commentListToCommentDetailsList(post.getComments()), post.getFlair(),
				cUtil.communityToCommunityDetails(post.getCommunity()));
		return dPost;
	}

	public List<PostDetails> postListToPostDetailsList(List<Post> posts) {
		List<PostDetails> list = posts.stream().map(p -> postToPostDetails(p)).collect(Collectors.toList());
		return list;
	}
}
