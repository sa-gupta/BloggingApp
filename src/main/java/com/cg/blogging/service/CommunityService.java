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

@Service("comService")
@Transactional
public class CommunityService implements ICommunityService {

	@Autowired
	private ICommunityRepository comRepo;
	
	@Override
	public Community addCommunity(Community community) {
		return comRepo.save(community);
	}

//	@Override
//	public Community updateCommunity(Community community) {
//		Optional<Community> opt = comRepo.findById(community.getCommunityId());
//		if(!opt.isPresent()) {
//			throw new IdNotFoundException("Id not found");
//		}
//		comRepo.updateCommunity(community);
//		return null;
//	}

	@Override
	public Community deleteCommunity(Community community) {
		Optional<Community> opt = comRepo.findById(community.getCommunityId());
		if(!opt.isPresent()) {
			throw new IdNotFoundException("Id not found");
		}
		comRepo.deleteById(community.getCommunityId());
		return opt.get();
	}

	@Override
	public List<Community> listAllCommunities(String searchString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Community> listAllCommunitiesByBlogger(Blogger blogger) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Community updateCommunity(Community community) {
		// TODO Auto-generated method stub
		return null;
	}

}
