package com.cg.blogging.service;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.cg.blogging.entities.Admin;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Community;
//import com.cg.blogging.entities.Post;
import com.cg.blogging.entities.User;
import com.cg.blogging.exception.IdNotFoundException;
import com.cg.blogging.repository.IBloggerRepository;
import com.cg.blogging.repository.IUserRepository;
//import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
/**
 * 
 * <h1>Blogger Service Class</h1>
 * <p>
 * This class allows to manage bloggers by providing CRUD operations using blogger
 * class. The CRUD operations can be called like:
 * {@link #addBlogger(Blogger)},{@link #updateBlogger(Blogger)}
 * {@link #deleteBlogger(Blogger)} and {@link #viewAllBloggers() )}
 * This class provides with other operations to find bloggers by community.
 * {@link #viewBloggerList(Community)}
 * 
 * @author SKSSS
 *
 */
@Service("bService")
@Transactional
public class BloggerService implements IBloggerService {

	private Logger logger = Logger.getLogger(BloggerService.class);
	
	@Autowired
	private IBloggerRepository bRepo;
	
	@Autowired
	private IUserRepository uRepo;
	
	/**
	 * Blogger Service method to add new blogger details into blogger repository.
	 */
	@Override
	public Blogger addBlogger(Blogger blogger) {
		User bloggerUser = uRepo.save(new User(blogger.getPassword(),"BLOGGER"));
		Blogger bloggerReturn = bRepo.save(new Blogger(bloggerUser.getUserId(), blogger.getBloggerName(), bloggerUser.getPassword()));
		logger.info("New Blogger added : " + bloggerReturn);
		return bloggerReturn;
	}
	
	/**
	 * <p>
	 * Blogger Service method to change the details of a blogger 
	 * by fetching the details from blogger repository
	 * using blogger Id.
	 * Injecting the changed details back into the repository.
	 * 
	 * @exception IdNotFoundException
	 * 
	 */
	@Override
	public Blogger updateBlogger(Blogger blogger){
		Optional<Blogger> opt = bRepo.findById(blogger.getUserId());
		if(!opt.isPresent()) {
			throw new IdNotFoundException("Id Not Found");
		}
		Blogger updatedBlogger = bRepo.save(blogger);
		Optional<User> userOpt = uRepo.findById(blogger.getUserId());
		userOpt.get().setPassword(blogger.getPassword());
		User updatedUser = uRepo.save(userOpt.get());
		logger.info("Blogger Data Updated : "+updatedBlogger);
		return updatedBlogger;
	}

	/**
	 * Blogger Service method to delete blogger details from the blogger repository.
	 * 
	 * @exception IdNotFoundException
	 */
	@Override
	public Blogger deleteBlogger(Blogger blogger){
		Optional<Blogger> opt = bRepo.findById(blogger.getUserId());
		if(!opt.isPresent()) {
			throw new IdNotFoundException("Id Not Found");
		}
		
		bRepo.deleteById(blogger.getUserId());
		uRepo.deleteById(blogger.getUserId());
		logger.info("Blogger Deleted : "+opt.get());
		return opt.get();
	}

	/**
	 * <p>
	 * Blogger Service method to view a blogger by using bloggerId
	 * and fetching details from the blogger repository.
	 */
	@Override
	public Blogger viewBlogger(int bloggerId){
		Optional<Blogger> opt = bRepo.findById(bloggerId);
		if(!opt.isPresent()) {
			throw new IdNotFoundException("Id Not Found");
		}
		return opt.get();
	}

	/**
	 * Blogger Service method to view all the blogger's details from the blogger repository.
	 */
	@Override
	public List<Blogger> viewAllBloggers() {
		List<Blogger> blog = bRepo.findAll();
		return blog;
	}
 
	/**
	 * <p>
	 * Blogger Service method to view blogger according to a community
	 * by using community Id. 
	 * Fetching details from community and blogger repositories.
	 */
	@Override
	public List<Blogger> viewBloggerList(Community community) {
		// TODO Auto-generated method stub
		return null;
	}

}
