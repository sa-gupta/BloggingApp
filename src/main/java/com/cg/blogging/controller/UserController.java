package com.cg.blogging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.blogging.entities.Admin;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.User;
import com.cg.blogging.exception.WrongCredentials;
import com.cg.blogging.service.IBloggerService;
import com.cg.blogging.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService uService;
	@Autowired
	private IBloggerService bService;
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public  User addNewUser(@RequestBody User user) {
		System.out.println("Request Data: "+ user);
		User rUser = uService.addNewUser(user);
		return rUser;
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add/admin")
	public  User addNewAdmin(@RequestBody Admin admin) {
		System.out.println("Request Data: "+ admin);
		User rUser = uService.addNewAdmin(admin);
		return rUser;
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add/blogger")
	public  User addNewBlogger(@RequestBody Blogger blogger) {
		System.out.println("Request Data: "+ blogger);
		Blogger rBlogger = bService.addBlogger(blogger);
		User rUser = new User(rBlogger.getUserId(), rBlogger.getPassword(), "BLOGGER");
		return rUser;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/signin")
	public User signIn(@RequestBody User user) {
		System.out.println("Request Data : "+user);
		User rUser = uService.signIn(user);
		if(!(rUser.getPassword().equals(user.getPassword()))) {
			throw new WrongCredentials("Wrong Password");
		}
		return rUser; 
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/signout")
	public User signOut(@RequestBody User user) {
		System.out.println("Request Data : "+user);
		User rUser = uService.signOut(user);
		return rUser; 
	}
}
