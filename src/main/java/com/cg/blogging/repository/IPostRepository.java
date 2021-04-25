package com.cg.blogging.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
//	public Post addPost(Post post);
//	public Post updatePost(Post post);
//	public Post deletePost(int id);
	@Query("from Post where LOWER(title) like %:searchStr%")
	public List<Post> getPostBySearchString(@Param("searchStr") String searchString);
//	public List<Post> getPostByBlogger(Blogger blogger);
//	public void upVote(boolean upVote);
	
	
}
