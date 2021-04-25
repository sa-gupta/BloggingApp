package com.cg.blogging.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Community;
import com.cg.blogging.exception.IdNotFoundException;
import com.cg.blogging.repository.ICommunityRepository;
/**
 * 
 * <h1>Community Service Class</h1>
 * <p>
 * This class allows to manage communities by providing CRUD operations using community
 * class. The CRUD operations can be called like:
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

	@Autowired
	private ICommunityRepository comRepo;
	
	
	/**
	 * Community Service method to add new community details into community repository.
	 * 
	 * @exception IdNotFoundException
	 */
	@Override
	public Community addCommunity(Community community) {
		return comRepo.save(community);
	}

	/**
	 * <p>
	 * Community Service method to change the details regarding a particular 
	 * community by fetching details from community repository.
	 * Injecting the changed details into the repository.
	 */
	@Override
	public Community updateCommunity(Community community) {
		Optional<Community> opt = comRepo.findById(community.getCommunityId());
		if(!opt.isPresent()) {
			throw new IdNotFoundException("Id not found");
		}
		return comRepo.save(community);
	}

	/**
	 * Community Service method to delete a community details from the community repository.
	 * 
	 * @exception IdNotFoundException
	 */
	@Override
	public Community deleteCommunity(Community community) {
		Optional<Community> opt = comRepo.findById(community.getCommunityId());
		if(!opt.isPresent()) {
			throw new IdNotFoundException("Id not found");
		}
		comRepo.deleteById(community.getCommunityId());
		return opt.get();
	}

	/**
	 * <p>
	 * Community Service method to view all the communities according to the search string
	 * provided by the user from the community repository.
	 */
	@Override
	public List<Community> listAllCommunities(String searchString) {
		return comRepo.listAllCommunities(searchString.toLowerCase());
	}

	/**
	 * <p>
	 * Community Service method to list all the commmunities which are related to a particular
	 * blogger from blogger and community repositories.
	 */
	@Override
	public List<Community> listAllCommunitiesByBlogger(Blogger blogger) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Community> listAllCommunities() {
		
		return comRepo.findAll();
	}

	


}
