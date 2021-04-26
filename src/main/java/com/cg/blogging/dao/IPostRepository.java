package com.cg.blogging.dao;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.blogging.entities.Blogger;
//import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Post;
/**
 * 
 * <h1>Podt Repository</h1>
 * This interface allows to manage CRUD operations on the post database.
 * @author SKSSS
 *
 */
public interface IPostRepository extends JpaRepository<Post, Integer>{

	@Query("from Post where LOWER(title) like %:searchStr%")
	public List<Post> getPostBySearchString(@Param("searchStr") String searchString);
	
	@Query(nativeQuery = true,value = "select * from post where blogger_id=:bloggerId")
	public List<Post> getPostByBlogger(@Param("bloggerId") int blogger_id);

	
	
}
