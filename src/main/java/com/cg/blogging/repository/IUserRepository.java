package com.cg.blogging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.blogging.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{

}
