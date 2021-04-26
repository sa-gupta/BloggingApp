package com.cg.blogging.dao;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Community;

//import com.cg.blogging.entities.Community;
//import com.cg.blogging.exception.IdNotFoundException;
/**
 * 
 * <h1>Blogger Repository</h1> This interface allows to manage CRUD operations
 * on the blogger database.
 * 
 * @author R.Kavya
 *
 */
@Repository
public interface IBloggerRepository extends JpaRepository<Blogger, Integer> {

	@Query(nativeQuery = true, value = "select * from blogger where user_id in (select blogger_user_id from blogger_communities where communities_community_id =:community_id)")
	public List<Blogger> viewBloggerList(@Param("community_id") int communityId);

}
