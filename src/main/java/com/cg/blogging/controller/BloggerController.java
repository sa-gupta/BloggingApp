package com.cg.blogging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Community;
//import com.cg.blogging.entities.Community;
import com.cg.blogging.service.IBloggerService;


/**
 * 
 * <h1>Blogger Controller Class</h1>
 * <p>
 * This class allows to inject blogger details through services by providing CRUD operations
 * using blogger class. The CRUD operations can be called like:
 * {@link #updateBlogger(Blogger)},{@link #deleteBlogger(Blogger)}
 * and {@link #viewAllBloggers()}
 * This class provides with other operations to find bloggers by community
 * and bloggers list.
 * {@link #viewBloggerList(Community)}
 * 
 * @author R.Kavya, Sachin Gupta
 *
 */
@RestController
@RequestMapping("/blogger")
public class BloggerController {
	@Autowired
	private IBloggerService bService;
	/**
	 * <p>
	 * To request the details of a blogger by using bloggerId
	 * and for fetching it use Service instance created.
	 * 
	 * @param bloggerId
	 * @return Blogger
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/view/{bloggerId}")
	public Blogger viewBlogger(@PathVariable("bloggerId") int bloggerId) {
		Blogger blogger = bService.viewBlogger(bloggerId);
		
		return blogger;
	}
	
	/**
	 * <p>
	 * To inject a particular blogger's new details and change the
	 * new details and inject them back into the repository through 
	 * service class.
	 * 
	 * @param blogger
	 * @return Blogger
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/update")
	public Blogger updateBlogger(@RequestBody Blogger blogger) {
		Blogger rBlogger = bService.updateBlogger(blogger);
		return rBlogger;
	}
	
	/**
	 * <p>
	 * To delete the details of a particular blogger
	 * with the access through service class and interface.
	 * 
	 * @param bloggerId
	 * @return Blogger
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping("/delete/{bloggerId}")
	public Blogger deleteBlogger(@PathVariable("bloggerId") int bloggerId) {
		System.out.println("Delete Request from client : "+bloggerId);
		Blogger rBlogger = bService.deleteBlogger(new Blogger(bloggerId));
		return rBlogger;
	}
	
	/**
	 * <p>
	 * This functions return the list of blogger who
	 * joined same community. 
	 * 
	 * @param community
	 * @return List<Blogger>
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/all/bycommunity")
	public List<Blogger> viewBloggerList(@RequestBody Community community){
		return bService.viewBloggerList(community);
	}
	
	/**
	 * <p>
	 * To view details of all the bloggers 
	 * and access their data from repository
	 * through service
	 * 
	 * @return List<Blogger>
	 */
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/all")
	public List<Blogger> viewAllBloggers(){
		List<Blogger> list = bService.viewAllBloggers();
		return list;
	}
}
