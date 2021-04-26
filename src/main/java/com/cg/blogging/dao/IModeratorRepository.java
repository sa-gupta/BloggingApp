package com.cg.blogging.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Moderator;
/**
 * 
 * <h1>Moderator Repository</h1>
 * This interface allows to manage CRUD operations on the Moderator database.
 * @author Sachin Gupta
 *
 */
@Repository
public interface IModeratorRepository extends JpaRepository<Moderator, Integer>{

}
