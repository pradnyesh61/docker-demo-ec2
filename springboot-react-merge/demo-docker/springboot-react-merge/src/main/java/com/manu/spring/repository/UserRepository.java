package com.manu.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manu.spring.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	

}
