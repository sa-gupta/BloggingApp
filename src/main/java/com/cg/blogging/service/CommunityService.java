package com.cg.blogging.service;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.blogging.dao.ICommunityRepository;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Community;
import com.cg.blogging.exception.IdNotFoundException;
import com.cg.blogging.util.ExceptionMessage;

/**
 * 
 * <h1>Community Service Class</h1>
 * <p>
 * This class allows to manage communities by providing CRUD operations using
 * community class. The CRUD operations can be called like:
 * {@link #addCommunity(Community)},{@link #updateCommunity(Community)}
 * {@link #deleteCommunity(Community)} and {@link #listAllCommunities(String)}
 * This class provides with other operations to find communities by blogger.
 * {@link #listAllCommunitiesByBlogger(Blogger)}
 * 
 * @author SKSSS
 *
 */
@Service("comService")
@Transactional
public class CommunityService implements ICommunityService {

	private Logger logger = Logger.getLogger(CommunityService.class);

	@Autowired
	private ICommunityRepository cRepo;

	/**
	 * Community Service method to add new community details into community
	 * repository.
	 * 
	 * @exception IdNotFoundException
	 */
	@Override
	public Community addCommunity(Community community) {
		Community returnCommunity = cRepo.save(community);
		logger.info("Community created : " + returnCommunity);
		return returnCommunity;
	}

	/**
	 * <p>
	 * Community Service method to change the details regarding a particular
	 * community by fetching details from community repository. Injecting the
	 * changed details into the repository.
	 */
	@Override
	public Community updateCommunity(Community community) {
		Optional<Community> opt = cRepo.findById(community.getCommunityId());
		if (!opt.isPresent()) {
			throw new IdNotFoundException(ExceptionMessage.COMMUNITY_NOT_FOUND);
		}
		logger.info("Community Updated : " + opt.get());
		return cRepo.save(community);
	}

	/**
	 * Community Service method to delete a community details from the community
	 * repository.
	 * 
	 * @exception IdNotFoundException
	 */
	@Override
	public Community deleteCommunity(Community community) {
		Optional<Community> opt = cRepo.findById(community.getCommunityId());
		if (!opt.isPresent()) {
			throw new IdNotFoundException(ExceptionMessage.COMMUNITY_NOT_FOUND);
		}
		cRepo.deleteById(community.getCommunityId());
		logger.info("Community Deleted : " + opt.get());
		return opt.get();
	}

	/**
	 * <p>
	 * Community Service method to view all the communities according to the search
	 * string provided by the user from the community repository.
	 */
	@Override
	public List<Community> listAllCommunities(String searchString) {
		return cRepo.listAllCommunities(searchString.toLowerCase());
	}

	/**
	 * <p>
	 * Community Service method to list all the commmunities which are related to a
	 * particular blogger from blogger and community repositories.
	 */
	@Override
	public List<Community> listAllCommunitiesByBlogger(int id) {
//		System.out.println(cRepo.listAllCommunitiesByBlogger(blogger.getUserId()));

		return cRepo.listAllCommunitiesByBlogger(id);
//		return null;
	}

	@Override
	public List<Community> listAllCommunities() {

		return cRepo.findAll();
	}

	@Override
	public Community communityById(int id) {
		Optional<Community> opt = cRepo.findById(id);
		if(!opt.isPresent()) {
			throw new IdNotFoundException(ExceptionMessage.ID_NOT_FOUND);
		}
		return opt.get();
	}

}
