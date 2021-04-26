package com.cg.blogging.service;

import java.util.List;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Community;
import com.cg.blogging.entities.Moderator;
import com.cg.blogging.exception.IdNotFoundException;

/**
 * 
 * <h1>Blogger Service Interface</h1>
 * <p>
 * This interface provides with all the methods to be implemented by the Blogger
 * Service Class
 * 
 * @author SKSSS
 *
 */
public interface IBloggerService {
	public Blogger addBlogger(Blogger blogger);

	public Blogger updateBlogger(Blogger blogger);

	public Blogger deleteBlogger(Blogger blogger);

	public Blogger viewBlogger(int bloggerId);

	public List<Blogger> viewAllBloggers();

	public List<Blogger> viewBloggerList(Community community);

	public Moderator addModerator(Moderator moderator);

	public List<Moderator> viewAllModerator();

	public Moderator viewModerator(int moderatorId);

}
