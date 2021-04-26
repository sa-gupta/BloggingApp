package com.cg.blogging.service;

import java.util.List;

//import javax.persistence.EntityManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.blogging.entities.Blogger;
//import com.cg.blogging.entities.User;

@ExtendWith({ SpringExtension.class })
@DataJpaTest
@Import(BloggerService.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BloggerServiceTest {
	@Autowired
	private IBloggerService bService;
//	@Autowired
//	private EntityManager em;
	
	@Test
	public void testAddBlogger() {
		Blogger blogger = new Blogger(0, "Sachin Gupta", "Sachin@123");
		Blogger exBlogger = bService.addBlogger(blogger);
		Assertions.assertEquals(exBlogger.getBloggerName(), blogger.getBloggerName());

	}
	
	@Test
	public void testUpdateBlogger() {
		Blogger blogger = bService.addBlogger(new Blogger("Sachin", null, null, null, null, null, 10, "Sachin@123"));
//		em.persist(blogger);
//		System.out.println(blogger.getUserId());
		blogger.setBloggerName("Satyam");
		blogger.setPassword("Satyam@123");
		blogger.setKarma(50);
		Blogger exBlogger = bService.updateBlogger(blogger);
		Assertions.assertEquals(exBlogger.getBloggerName(), blogger.getBloggerName());

	}
	
	@Test
	public void testDeleteBlogger() {
		Blogger blogger = bService.addBlogger(new Blogger("Sachin", null, null, null, null, null, 10, "Sachin@123"));
		Blogger exBlogger = bService.deleteBlogger(blogger);
		Assertions.assertEquals(exBlogger.getBloggerName(), blogger.getBloggerName());

	}
	
	@Test
	public void testViewBlogger() {
		Blogger blogger = bService.addBlogger(new Blogger("Sachin", null, null, null, null, null, 10, "Sachin@123"));
		Blogger exBlogger = bService.viewBlogger(blogger.getUserId());
		Assertions.assertEquals(exBlogger.getBloggerName(), blogger.getBloggerName());

	}
	
	@Test
	public void testViewAllBlogger() {
		Blogger blogger1 = bService.addBlogger(new Blogger("Sachin", null, null, null, null, null, 10, "Sachin@123"));
		Blogger blogger2 = bService.addBlogger(new Blogger("Sachin", null, null, null, null, null, 10, "Sachin@123"));
		Blogger blogger3 = bService.addBlogger(new Blogger("Sachin", null, null, null, null, null, 10, "Sachin@123"));

		Blogger blogger4 = new Blogger("Sachin", null, null, null, null, null, 10, "Sachin@123");
		List<Blogger> bloggerList = bService.viewAllBloggers();
		Assertions.assertTrue(bloggerList.contains(blogger3));

	}
}
