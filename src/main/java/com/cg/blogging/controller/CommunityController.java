package com.cg.blogging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.blogging.entities.Comment;
import com.cg.blogging.entities.Community;
import com.cg.blogging.service.ICommunityService;

@RestController
@RequestMapping("/community")
public class CommunityController {
	
	@Autowired
	private ICommunityService comService;
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public Community addCommunity(@RequestBody Community community) {
		System.out.println("Community from client : "+community);
		Community commReturn = comService.addCommunity(community);
		System.out.println(commReturn.getPostRulesAllowed().get(0));
		return commReturn;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/delete/{id}")
	public Community deleteCommunity(@PathVariable("id") Community community) {
		System.out.println("Delete Request from client : "+community);
		Community commReturn = comService.deleteCommunity(community);
//		System.out.println(commReturn.getPostRulesAllowed().get(0));
		return commReturn;
	}
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/allcommunity")
	public List<Community> listAllCommunities(String searchString){
		return null;
	}
}
