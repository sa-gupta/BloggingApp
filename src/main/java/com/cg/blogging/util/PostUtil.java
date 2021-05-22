package com.cg.blogging.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.blogging.dto.PostDetails;
import com.cg.blogging.dto.PostRequest;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Community;
import com.cg.blogging.entities.Post;
import com.cg.blogging.entities.PostType;

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
				post.getCreatedBy().getBloggerName(), post.getContent(), post.getData(),
				post.getCreatedDateTime(), post.getFlair(),post.getCommunity().getCommunityName(),post.getCommunity().getCommunityId(),
				post.getCreatedBy().getUserId());
		return dPost;
	}

	public List<PostDetails> postListToPostDetailsList(List<Post> posts) {
		List<PostDetails> list = posts.stream().map(p -> postToPostDetails(p)).collect(Collectors.toList());
		return list;
	}
	
	public Post postReqToPost (PostRequest req) {
		Post post = new Post(req.getPostId(),req.getTitle(),new Blogger(req.getBloggerId()),PostType.TEXT,req.getData(),req.getCreatedDateTime(),null,
				0,false,false,false,false,req.getFlair(),new Community(req.getCommunityId()));
		
		return post;
	} 
}
