package com.cg.blogging.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Moderator;

@Repository
public interface IModeratorRepository extends JpaRepository<Moderator, Integer>{

}
