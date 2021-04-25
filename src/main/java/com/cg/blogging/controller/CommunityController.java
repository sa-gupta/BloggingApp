package com.cg.blogging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.blogging.entities.Blogger;
//import com.cg.blogging.entities.Comment;
import com.cg.blogging.entities.Community;
import com.cg.blogging.service.ICommunityService;

/**
 * 
 * <h1>Community Controller Class</h1>
 * <p>
 * This class allows to inject and request communities details through service by 
 * providing CRUD operations using community class.
 * The CRUD operations can be called like:
 * {@link #addCommunity(Community)},{@link #updateCommunity(Community)}
 * {@link #deleteCommunity(Community)} and {@link #listAllCommunities(String)}
 * This class provides with other operations to find communities by blogger.
 * {@link #listAllCommunitiesByBlogger(Blogger)}
 * 
 * @author SKSSS
 *
 */
@RestController
@RequestMapping("/community")
public class CommunityController {
	
	@Autowired
	private ICommunityService comService;
	
	/**
	 * To inject details of the new community into repository.
	 * 
	 * @param community
	 * @return Community
	 */
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public Community addCommunity(@RequestBody Community community) {
		System.out.println("Community from client : "+community);
		Community commReturn = comService.addCommunity(community);
		System.out.println(commReturn.getPostRulesAllowed().get(0));
		return commReturn;
	}
	
	
	/**
	 * To request details of a community and delete them from repository.
	 * 
	 * @param community
	 * @return Community
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/delete/{id}")
	public Community deleteCommunity(@PathVariable("id") Community community) {
		System.out.println("Delete Request from client : "+community);
		Community commReturn = comService.deleteCommunity(community);
//		System.out.println(commReturn.getPostRulesAllowed().get(0));
		return commReturn;
	}
	
	/**
	 * <p>
	 * To request for viewing the list of all the communities 
	 * present in the repository.
	 * 
	 * @param searchString
	 * @return List<Community>
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/all/{searchString}")
	public List<Community> listAllCommunities(@PathVariable("searchString") String searchString){
		
		return comService.listAllCommunities(searchString);
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/all")
	public List<Community> listAllCommunities(){
		return comService.listAllCommunities();
	}
	
	/**
	 * <p>
	 * To request details of a community.
	 * To change the values of the details.
	 * Inject them back into the repository. 
	 * 
	 * @param community
	 * @return Community
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/update")
	public Community updateCommunity(@RequestBody Community community) {
		System.out.println("Update Request from client : "+community);
		Community commReturn = comService.updateCommunity(community);
		return commReturn;
	}
}
