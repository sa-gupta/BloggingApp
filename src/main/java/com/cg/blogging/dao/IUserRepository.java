package com.cg.blogging.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.blogging.entities.User;

/**
 * 
 * <h1>User Repository</h1> This interface allows to manage CRUD operations on
 * the user database.
 * 
 * @author Sachin Gupta
 *
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

}
