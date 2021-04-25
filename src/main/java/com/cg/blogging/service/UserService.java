package com.cg.blogging.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.blogging.entities.Admin;
import com.cg.blogging.entities.User;
import com.cg.blogging.exception.IdNotFoundException;
import com.cg.blogging.repository.IAdminRepository;
import com.cg.blogging.repository.IUserRepository;
/**
 * 
 * <h1>User Service Class</h1>
 * <p>
 * This class allows to inject user's details into user repository by methods
 * implemented in User Service Interface. The repository insertion operations can be called like:
 * {@link #addNewUser(User)},{@link #addNewAdmin(Admin)}
 * {@link #signIn(User)},{@link #signOut(User)}
 * 
 * @author SKSSS
 *
 */
@Service("uService")
@Transactional
public class UserService implements IUserService {

	private Logger logger = Logger.getLogger(UserService.class);
	
	@Autowired
	private IUserRepository userRepo;
	@Autowired
	private IAdminRepository adminRepo;
	/**
	 * User class method for adding new user details into user repository.
	 */
	@Override
	public User addNewUser(User user) {
		return userRepo.save(user);
	}

	/**
	 * 
	 * User Service method for checking user existence in user repository.
	 * 
	 * @exception IdNotFoundException
	 */
	@Override
	public User signIn(User user) {
		Optional<User> opt = userRepo.findById(user.getUserId());
		if(!opt.isPresent()) {
			throw new IdNotFoundException("Id doesn't exist");
		}
		logger.info("User Signed In : "+opt.get());
		return opt.get();
	}
	
	/**
	 * User Service method for checking out the user.
	 * 
	 * @exception IdNotFoundException
	 */
	@Override
	public User signOut(User user) {
		Optional<User> opt = userRepo.findById(user.getUserId());
		if(!opt.isPresent()) {
			throw new IdNotFoundException("Id doesn't exist");
		}
		return opt.get();
	}

	/**
	 * User class method for adding admin details into user and admin repository.
	 */
	@Override
	public User addNewAdmin(Admin admin) {
		User adminUser = userRepo.save(new User(admin.getPassword(),"ADMIN"));
		Admin adminReturn = adminRepo.save(new Admin(adminUser.getUserId(), admin.getAdminName(),
				admin.getAdminContact(), adminUser.getPassword()));
		logger.info("New Admin Created : "+adminReturn);
		return adminUser;
	}

}
