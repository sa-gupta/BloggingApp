package com.cg.blogging.service;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.blogging.entities.User;

@ExtendWith({ SpringExtension.class })
@DataJpaTest
@Import(UserService.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserServiceTest {
	@Autowired
	private IUserService uService;
	@Autowired
	private EntityManager em;

	@Test
	public void testAddNewUser() {
		User user = new User("sachin123", "BLOGGER");
		User userAdded = uService.addNewUser(user);
		Assertions.assertEquals(userAdded.getPassword(), user.getPassword());

	}
	
	@Test
	public void testSignIn() {
		User user = new User("sachin123", "BLOGGER");
		em.persist(user);
		User userAdded = uService.signIn(user);
		Assertions.assertEquals(userAdded.getPassword(), user.getPassword());

	}
	
}
