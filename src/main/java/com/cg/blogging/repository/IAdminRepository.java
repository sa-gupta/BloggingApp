package com.cg.blogging.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.blogging.entities.Admin;
@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer>{

}
