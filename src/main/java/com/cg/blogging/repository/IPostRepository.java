package com.cg.blogging.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

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
//	public List<Post> getPostBySearchString(String searchStr);
//	public List<Post> getPostByBlogger(Blogger blogger);
//	public void upVote(boolean upVote);
	
	
}
