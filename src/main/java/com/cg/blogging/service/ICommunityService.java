package com.cg.blogging.service;

import java.util.List;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Community;
/**
 * 
 * <h1>Community Service Interface</h1>
 * <p>
 * This interface provides with all the methods 
 * to be implemented by the Community Service Class
 * 
 * @author SKSSS
 *
 */
public interface ICommunityService {
	public Community addCommunity(Community community);
	public Community updateCommunity(Community community);
	public Community deleteCommunity(Community community);
	public List<Community> listAllCommunities(String searchString);
	public List<Community> listAllCommunitiesByBlogger(Blogger blogger);
	public List<Community> listAllCommunities();
}
