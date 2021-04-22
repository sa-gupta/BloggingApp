package com.cg.blogging.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Post;
import com.cg.blogging.repository.IPostRepository;

@Service("pService")
@Transactional
public class PostService implements IPostService {

	@Autowired
	private IPostRepository pRepo;
	
	@Override
	public Post addPost(Post post) {
		return pRepo.save(post);
	}

	@Override
	public Post updatePost(Post post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post deletePost(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostBySearchString(String searchStr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPostByBlogger(Blogger blogger) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void upVote(boolean upVote) {
		// TODO Auto-generated method stub

	}

}
