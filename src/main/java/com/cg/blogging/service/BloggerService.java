package com.cg.blogging.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.blogging.dao.IBloggerRepository;
import com.cg.blogging.dao.IModeratorRepository;
import com.cg.blogging.dao.IUserRepository;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Community;
import com.cg.blogging.entities.Moderator;
import com.cg.blogging.entities.User;
import com.cg.blogging.exception.IdNotFoundException;
import com.cg.blogging.util.ExceptionMessage;
import com.cg.blogging.util.Role;

/**
 * 
 * <h1>Blogger Service Class</h1>
 * <p>
 * This class allows to manage bloggers by providing CRUD operations using
 * blogger class. The CRUD operations can be called like:
 * {@link #addBlogger(Blogger)},{@link #updateBlogger(Blogger)}
 * {@link #deleteBlogger(Blogger)} and {@link #viewAllBloggers() )} This class
 * provides with other operations to find bloggers by community.
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
	private IModeratorRepository mRepo;

	@Autowired
	private IUserRepository uRepo;

	@Autowired
	EntityManager em;

	/**
	 * Blogger Service method to add new blogger details into blogger repository.
	 */
	@Override
	public Blogger addBlogger(Blogger blogger) {
		User bloggerUser = uRepo.save(new User(blogger.getPassword(), Role.BLOGGER));
		Blogger bloggerReturn = bRepo
				.save(new Blogger(bloggerUser.getUserId(), blogger.getBloggerName(), bloggerUser.getPassword()));
		logger.info("New Blogger added : " + bloggerReturn);
		return bloggerReturn;
	}

	/**
	 * <p>
	 * Blogger Service method to change the details of a blogger by fetching the
	 * details from blogger repository using blogger Id. Injecting the changed
	 * details back into the repository.
	 * 
	 * @exception IdNotFoundException
	 * 
	 */
	@Override
	public Blogger updateBlogger(Blogger blogger) {
		Optional<Blogger> opt = bRepo.findById(blogger.getUserId());

		if (!opt.isPresent()) {
			throw new IdNotFoundException(ExceptionMessage.ID_NOT_FOUND);
		}
		blogger.setBloggerName(opt.get().getBloggerName());
		blogger.setPassword(opt.get().getPassword());
		Blogger updatedBlogger = bRepo.save(blogger);
		Optional<User> userOpt = uRepo.findById(blogger.getUserId());
		userOpt.get().setPassword(blogger.getPassword());
		User updatedUser = uRepo.save(userOpt.get());
		logger.info("Blogger Data Updated : " + updatedBlogger);
		return updatedBlogger;
	}

	/**
	 * Blogger Service method to delete blogger details from the blogger repository.
	 * 
	 * @exception IdNotFoundException
	 */
	@Override
	public Blogger deleteBlogger(Blogger blogger) {
		Optional<Blogger> opt = bRepo.findById(blogger.getUserId());
		if (!opt.isPresent()) {
			throw new IdNotFoundException(ExceptionMessage.ID_NOT_FOUND);
		}

		bRepo.deleteById(blogger.getUserId());
		uRepo.deleteById(blogger.getUserId());
		logger.info("Blogger Deleted : " + opt.get());
		return opt.get();
	}

	/**
	 * <p>
	 * Blogger Service method to view a blogger by using bloggerId and fetching
	 * details from the blogger repository.
	 */
	@Override
	public Blogger viewBlogger(int bloggerId) {
		Optional<Blogger> opt = bRepo.findById(bloggerId);
		if (!opt.isPresent()) {
			throw new IdNotFoundException(ExceptionMessage.ID_NOT_FOUND);
		}
		return opt.get();
	}

	/**
	 * Blogger Service method to view all the blogger's details from the blogger
	 * repository.
	 */
	@Override
	public List<Blogger> viewAllBloggers() {
		List<Blogger> blog = bRepo.findAll();
		return blog;
	}

	/**
	 * <p>
	 * Blogger Service method to view blogger according to a community by using
	 * community Id. Fetching details from community and blogger repositories.
	 */
	@Override
	public List<Blogger> viewBloggerList(Community community) {
		return bRepo.viewBloggerList(community.getCommunityId());
	}

	@Override
	public Moderator addModerator(Moderator moderator) {
		User bloggerUser = uRepo.save(new User(moderator.getPassword(), Role.MODERATOR));
//		EntityManager em;
		moderator.setUserId(bloggerUser.getUserId());
		em.persist(moderator);
//		Moderator moderatorReturn = bRepo.save(new Blogger(bloggerUser.getUserId(), blogger.getBloggerName(), bloggerUser.getPassword()));
		logger.info("New Moderator added : " + moderator);
		return moderator;
	}

	/**
	 * <p>
	 * This function calls the findAll function of JPARepository using
	 * variable{@link #bRepo}}
	 * 
	 * @return List<Moderator>
	 */
	@Override
	public List<Moderator> viewAllModerator() {
		return mRepo.findAll();
	}

	/**
	 * <p>
	 * This function passes data to DAO Layer and fetches the moderator form there.
	 * 
	 * 
	 * @param moderatorId
	 * @return Moderator
	 */
	@Override
	public Moderator viewModerator(int moderatorId) {
		Optional<Moderator> opt = mRepo.findById(moderatorId);
		if (!opt.isPresent()) {
			throw new IdNotFoundException(ExceptionMessage.ID_NOT_FOUND);
		}

		return opt.get();
	}

}
