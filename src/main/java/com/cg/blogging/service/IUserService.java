package com.cg.blogging.service;

import com.cg.blogging.entities.Admin;
//import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.User;

/**
 * 
 * <h1>User Service Interface</h1>
 * <p>
 * This interface provides with all the methods to be implemented by the User
 * Service Class
 * 
 * @author SKSSS
 *
 */
public interface IUserService {
	public User addNewUser(User user);

	public User signIn(User user);

	public User signOut(User user);

	public User addNewAdmin(Admin admin);

}
