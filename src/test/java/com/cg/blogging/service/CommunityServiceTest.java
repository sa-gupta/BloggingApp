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

import com.cg.blogging.entities.Community;

@ExtendWith({ SpringExtension.class })
@DataJpaTest
@Import(CommunityService.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CommunityServiceTest {
	@Autowired
	private ICommunityService cService;
	@Autowired
	private EntityManager em;
	
	@Test
	public void testAddCommunity(){
		Community community = new Community("Comm Desc", 12, 10, null, null, null, null, null);
		Community exCommunity = cService.addCommunity(community);
		Assertions.assertEquals(exCommunity.getCommunityId(), community.getCommunityId());
	}
	
	
}
