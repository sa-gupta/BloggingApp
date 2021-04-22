package com.cg.blogging.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Community;
import com.cg.blogging.entities.Post;
import com.cg.blogging.entities.User;
import com.cg.blogging.exception.IdNotFoundException;
import com.cg.blogging.repository.IBloggerRepository;
import com.cg.blogging.repository.IUserRepository;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

@Service("bService")
@Transactional
public class BloggerService implements IBloggerService {

	@Autowired
	private IBloggerRepository bRepo;
	
	@Autowired
	private IUserRepository uRepo;
	
	@Override
	public Blogger addBlogger(Blogger blogger) {
		Blogger rBlogger = bRepo.save(blogger);
		uRepo.save(new User(rBlogger.getUserId(), rBlogger.getPassword(), "BLOGGER"));
		return rBlogger;
	}

	@Override
	public Blogger updateBlogger(Blogger blogger){
		Optional<Blogger> opt = bRepo.findById(blogger.getUserId());
		if(!opt.isPresent()) {
			throw new IdNotFoundException("Id Not Found");
		}
		Blogger updatedBlogger = bRepo.save(blogger);
		return updatedBlogger;
	}

	@Override
	public Blogger deleteBlogger(Blogger blogger){
		Optional<Blogger> opt = bRepo.findById(blogger.getUserId());
		if(!opt.isPresent()) {
			throw new IdNotFoundException("Id Not Found");
		}
		
		bRepo.deleteById(blogger.getUserId());
		uRepo.deleteById(blogger.getUserId());
		return opt.get();
	}

	@Override
	public Blogger viewBlogger(int bloggerId){
		Optional<Blogger> opt = bRepo.findById(bloggerId);
		if(!opt.isPresent()) {
			throw new IdNotFoundException("Id Not Found");
		}
		return opt.get();
	}

	@Override
	public List<Blogger> viewAllBloggers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Blogger> viewBloggerList(Community community) {
		// TODO Auto-generated method stub
		return null;
	}

}
