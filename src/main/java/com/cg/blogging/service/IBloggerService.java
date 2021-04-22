package com.cg.blogging.service;

import java.util.List;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Community;
import com.cg.blogging.exception.IdNotFoundException;


public interface IBloggerService {
	public Blogger addBlogger(Blogger blogger);
	public Blogger updateBlogger(Blogger blogger);
	public Blogger deleteBlogger(Blogger blogger);
	public Blogger viewBlogger(int bloggerId);
	public List<Blogger> viewAllBloggers();
	public List<Blogger> viewBloggerList(Community community);
	//public List<Customer> viewCustomerList(int theatreid);

}
