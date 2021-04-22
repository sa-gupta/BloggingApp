package com.cg.blogging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Community;
import com.cg.blogging.service.IBloggerService;

@RestController
@RequestMapping("/blogger")
public class BloggerController {
	@Autowired
	private IBloggerService bService;
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{bloggerId}")
	public Blogger viewBlogger(@PathVariable("bloggerId") int bloggerId) {
		Blogger blogger = bService.viewBlogger(bloggerId);
		return blogger;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/update")
	public Blogger updateBlogger(@RequestBody Blogger blogger) {
		Blogger rBlogger = bService.updateBlogger(blogger);
		return rBlogger;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/delete/{bloggerId}")
	public Blogger deleteBlogger(@PathVariable("bloggerId") int bloggerId) {
		System.out.println("Delete Request from client : "+bloggerId);
		Blogger rBlogger = bService.deleteBlogger(new Blogger(bloggerId));
		return rBlogger;
	}
	
	@GetMapping("/blogs")
	public List<Blogger> viewAllBloggers(){
		List<Blogger> list = bService.viewAllBloggers();
		return list;
	}
}
