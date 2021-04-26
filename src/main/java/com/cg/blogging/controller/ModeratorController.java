package com.cg.blogging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Moderator;
import com.cg.blogging.service.IBloggerService;

@RestController
@RequestMapping("/moderator")
public class ModeratorController {
	
	@Autowired
	private IBloggerService bService;
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/all")
	public List<Moderator> viewAllModerator() {
		List<Moderator> moderators = bService.viewAllModerator();
		
		return moderators;
	}
	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{id}")
	public Moderator viewModerator(@PathVariable("id") int moderatorId) {
		return bService.viewModerator(moderatorId);
	}
}
