package com.cg.blogging.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Community;

@Repository
public interface ICommunityRepository extends JpaRepository<Community, Integer>{
//	public Community addCommunity(Community community);
//	@Query("")
//	public Community updateCommunity(Community community);
//	public Community deleteCommunity(Community community);
//	public List<Community> listAllCommunities(String searchString);
//	public List<Community> listAllCommunitiesByBlogger(Blogger blogger);
}
