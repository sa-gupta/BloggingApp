package com.cg.blogging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.blogging.entities.Moderator;
import com.cg.blogging.service.IBloggerService;

/**
 * 
 * <h1>Moderator Controller Class</h1>
 * <p>
 * 
 * This class allows to inject Moderator details through services by providing
 * CRUD operations using Moderator class. The CRUD operations can be called
 * like: {@link #viewModerator()},{@link #viewAllModerator(moderatorId)}
 *
 * Moderator can Shadow post and comment.
 * 
 * @author Saiyam Anand
 *
 */
@RestController
@RequestMapping("/moderator")
public class ModeratorController {

	@Autowired
	private IBloggerService bService;

	/**
	 * This function gives the list of all moderators in Database
	 *
	 * @return List<Moderators>
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/all")
	public List<Moderator> viewAllModerator() {
		List<Moderator> moderators = bService.viewAllModerator();

		return moderators;
	}

	/**
	 * This function return moderator by given ID
	 * 
	 * 
	 * @param moderatorId
	 * @return Moderator
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{id}")
	public Moderator viewModerator(@PathVariable("id") int moderatorId) {
		return bService.viewModerator(moderatorId);
	}
}
