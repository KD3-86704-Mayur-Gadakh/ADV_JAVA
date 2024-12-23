package com.ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.entities.User;

public interface UserDao extends JpaRepository<User,Long> {
	
	

}
