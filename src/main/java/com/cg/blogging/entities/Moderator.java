package com.cg.blogging.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 
 * <h1>Moderator Class</h1>
 * <p>
 * This class moderates/shadows 
 * the comments and posts 
 * that have sensitive content.
 * 
 *  @author SKSSS
 *
 */

@Entity
@DiscriminatorValue("MODERATOR")
public class Moderator extends Blogger {
	/**
	 * Moderator class constructor.
	 */
	
	public boolean moderatesPostsAndComments() {return false;}

}
