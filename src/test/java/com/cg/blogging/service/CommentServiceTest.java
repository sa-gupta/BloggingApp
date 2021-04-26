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
import com.cg.blogging.entities.Comment;
import com.cg.blogging.entities.Post;


@ExtendWith({ SpringExtension.class })
@DataJpaTest
@Import(CommentService.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CommentServiceTest {
	@Autowired
	private ICommentService cService;
	@Autowired
	private EntityManager em;
	
	
	@Test
	public void testAddComment() {
		Comment comment = new Comment("Hi", new Blogger(2), new Post(2));
		Comment exComment = cService.addComment(comment);
		Assertions.assertEquals(exComment.getBlogger(), comment.getBlogger());
	}
	
	@Test
	public void testDeleteComment() {
		Comment comment = cService.addComment(new Comment("Hi", new Blogger(2), new Post(2)));
		cService.deleteComment(comment);
//		Assertions.assertEquals(exComment.getBlogger(), comment.getBlogger());
	}
}
