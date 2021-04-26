package com.cg.blogging.service;

import java.util.List;

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
	
	@Test
	public void testUpdateCommunity() {
		Community com =  cService.addCommunity(new Community("Trial", 100, 50, null, null, null, null, null));
		com.setCommunityDescription("TrialSuccess");
		com.setTotalMembers(80);
		com.setOnlineMembers(25);
		Community exCom = cService.updateCommunity(com);
		Assertions.assertEquals(exCom.getCommunityDescription(), com.getCommunityDescription());
	}
	
	@Test
	public void testDeleteCommunity() {
		Community com = cService.addCommunity(new Community("Trial2", 50, 10, null, null, null, null, null));
		Community exCom = cService.deleteCommunity(com);
		Assertions.assertEquals(exCom.getCommunityDescription(), com.getCommunityDescription());
	}
	
	@Test
	public void testListAllCommunities() {
		Community com1 = cService.addCommunity(new Community("Trial1", 50, 10, null, null, null, null, null));
		Community com2 = cService.addCommunity(new Community("Trial2", 50, 10, null, null, null, null, null));
		Community com3 = cService.addCommunity(new Community("Trial3", 50, 10, null, null, null, null, null));
		Community com4 = new Community("Trial2", 50, 10, null, null, null, null, null);
		List<Community> comList = cService.listAllCommunities();
		Assertions.assertTrue(comList.contains(com3));
	}
	
	@Test
	public void testCommunitiesBySearchString() {
		Community com1 = cService.addCommunity(new Community("Trial1", 50, 10, null, null, null, null, null));
		Community com2 = cService.addCommunity(new Community("Trial2", 50, 10, null, null, null, null, null));
		Community com3 = cService.addCommunity(new Community("Trial3", 50, 10, null, null, null, null, null));
		List<Community> comList = cService.listAllCommunities("rial");
		Assertions.assertTrue(comList.get(2).getCommunityDescription().contains("rial"));
	}
}
