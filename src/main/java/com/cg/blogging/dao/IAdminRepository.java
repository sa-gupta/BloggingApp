package com.cg.blogging.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.blogging.entities.Admin;

/**
 * 
 * <h1>Admin Repository</h1> This interface allows to manage CRUD operations on
 * the admin database.
 * 
 * @author Sachin Gupta
 *
 */
@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {

}
