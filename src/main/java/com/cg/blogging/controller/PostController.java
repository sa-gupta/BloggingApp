package com.cg.blogging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.blogging.entities.Post;
import com.cg.blogging.service.IPostService;

@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	private IPostService pService;
	
	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping("/add")
	public Post addPost(@RequestBody Post post) {
		System.out.println("Add Request from client : "+post);
		Post rPost = pService.addPost(post);
		return rPost;
	}
}
