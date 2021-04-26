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

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Community;
import com.cg.blogging.entities.Post;
import com.cg.blogging.entities.PostType;

@ExtendWith({ SpringExtension.class })
@DataJpaTest
@Import(PostService.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PostServiceTest {
	@Autowired
	private IPostService pService;
	@Autowired
	private EntityManager em;
	
//	@Test
//	public void testAddPost() {
//		Post post = new Post(1,"First Post",new Blogger(2, "Sachin","Sachin@123"),PostType.TEXT,"Flair1",new Community(communityId));
//		Post exPost = pService.addPost(post);
//		Assertions.assertEquals(exPost.getPostId(), post.getPostId());
//	}
}
