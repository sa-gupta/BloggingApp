package com.cg.blogging.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.blogging.entities.Blogger;
//import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Community;
/**
 * 
 * <h1>Community Repository</h1>
 * This interface allows to manage CRUD operations on the community database.
 * @author SKSSS
 *
 */
@Repository
public interface ICommunityRepository extends JpaRepository<Community, Integer>{
//	public Community addCommunity(Community community);
//	@Query("")
//	public Community updateCommunity(Community community);
//	public Community deleteCommunity(Community community);
	
	@Query("from Community where LOWER(communityDescription) like %:searchStr%")
	public List<Community> listAllCommunities(@Param("searchStr") String searchString);
	
	@Query(nativeQuery = true,value = "select * from community where community_id in (select communities_community_id "
			+ "from blogger_communities where blogger_User_id =:user_id)")
	public List<Community> listAllCommunitiesByBlogger(@Param("user_id") int bloggerId);
}
