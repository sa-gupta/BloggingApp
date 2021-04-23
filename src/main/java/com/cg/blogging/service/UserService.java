package com.cg.blogging.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.blogging.entities.Admin;
import com.cg.blogging.entities.User;
import com.cg.blogging.exception.IdNotFoundException;
import com.cg.blogging.repository.IAdminRepository;
import com.cg.blogging.repository.IUserRepository;

@Service("uService")
@Transactional
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepo;
	@Autowired
	private IAdminRepository adminRepo;
	
	@Override
	public User addNewUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User signIn(User user) {
		Optional<User> opt = userRepo.findById(user.getUserId());
		if(!opt.isPresent()) {
			throw new IdNotFoundException("Id doesn't exist");
		}
		
		return opt.get();
	}

	@Override
	public User signOut(User user) {
		Optional<User> opt = userRepo.findById(user.getUserId());
		if(!opt.isPresent()) {
			throw new IdNotFoundException("Id doesn't exist");
		}
		return opt.get();
	}

	@Override
	public User addNewAdmin(Admin admin) {
		User adminUser = userRepo.save(new User(admin.getPassword(),"ADMIN"));
		Admin adminReturn = adminRepo.save(new Admin(adminUser.getUserId(), admin.getAdminName(),
				admin.getAdminContact(), adminUser.getPassword()));
		return adminUser;
	}

}
